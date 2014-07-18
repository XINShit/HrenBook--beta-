

import hrenbook.engine.MainEngine;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;


public class registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action") != null) {
            MainEngine mainEngine = new MainEngine();
            mainEngine.Register(req.getParameter("login"),req.getParameter("password"),
                    req.getParameter("name"),req.getParameter("lastname"), Integer.valueOf(req.getParameter("age")));
            Label q = DynamicLabel.label("q");
        }
        req.getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
    }
}
