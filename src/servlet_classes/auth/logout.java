package servlet_classes.auth;

import hrenbook.engine.MainEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Beta on 7/19/14.
 */
public class logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("logouting...");
        MainEngine.logout(req.getSession().getId());
        System.out.println("redirect to login page...");
        resp.sendRedirect("login");
    }
}
