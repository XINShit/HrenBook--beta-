package servlet_classes.auth;

import hrenbook.DB_GLOBAL.neo4j.Utils;
import hrenbook.Exceptions.UserNotFoundByIdException;
import hrenbook.Exceptions.WrongPasswordEexception;
import hrenbook.engine.MainEngine;
import hrenbook.engine.UserProfileEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Beta on 7/19/14.
 */
public class login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/auth/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO Сделать это при запуске серва!!!
        if(!MainEngine.runned) {
            MainEngine.init();
        }
        if(req.getParameter("action") != null) {
            try {
                MainEngine.login(req.getParameter("login").toString(),
                        req.getParameter("password").toString(),req.getSession().getId());
            } catch (WrongPasswordEexception wrongPasswordEexception) {
                wrongPasswordEexception.printStackTrace();

                req.setAttribute("error",wrongPasswordEexception.getMessage());
                req.getRequestDispatcher("/jsp/auth/login.jsp").forward(req, resp);
                return;
            } catch (Exception e){
                e.printStackTrace();
                req.getRequestDispatcher("/jsp/404.htm").forward(req, resp);
                return;
            }
        }
        /*
        Long myId = MainEngine.getIdFromSSID(req.getSession().getId());
        if(myId != null) {
            try {
                req.setAttribute("gravatar",
                        new UserProfileEngine().getGravatar(myId));

            } catch (UserNotFoundByIdException e) {
                req.getRequestDispatcher("/jsp/error/404.htm").forward(req, resp);
                e.printStackTrace();
            }
        }*/
        resp.sendRedirect("/profile");
        //req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
    }
}

