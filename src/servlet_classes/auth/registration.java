package servlet_classes.auth;

import hrenbook.Exceptions.UserExcistingException;
import hrenbook.engine.MainEngine;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/auth/registration.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action") != null) {


            //TODO Сделать это при запуске серва!!!
            if(!MainEngine.runned) {
                MainEngine.init();
            }

            try {
                MainEngine.Register(req.getParameter("login"),req.getParameter("password"),
                        req.getParameter("email"), req.getParameter("name"),
                       req.getParameter("lastname"), Integer.valueOf(req.getParameter("age")));
            } catch (UserExcistingException e) {
                req.setAttribute("error","<div class=\"alert alert-danger\" role=\"alert\">" +
                        e.getMessage() +
                        "</div>");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
                req.getRequestDispatcher("/jsp/error/404.htm").forward(req, resp);
            }


        }
        req.getRequestDispatcher("/jsp/auth/login.jsp").forward(req, resp);
    }
}
