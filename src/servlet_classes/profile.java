package servlet_classes;

import hrenbook.Exceptions.UserNotFoundByIdException;
import hrenbook.engine.UserProfileEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Beta on 7/19/14.
 */
public class profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("gravatar",
                    UserProfileEngine.getGravatar(req.getSession().getId()));
            Properties profileInfos = UserProfileEngine.getProfileInfos(req.getSession().getId());
            req.setAttribute("name",profileInfos.get("name"));
            req.setAttribute("lastname",profileInfos.get("lastname"));
            req.setAttribute("age",profileInfos.get("age"));
        } catch (UserNotFoundByIdException e) {
            e.printStackTrace();
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/jsp/auth/login.jsp").forward(req, resp);
            return;
        } catch (Exception e){
            e.printStackTrace();
            req.getRequestDispatcher("/jsp/404.htm").forward(req, resp);
            return;
        }

        req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
