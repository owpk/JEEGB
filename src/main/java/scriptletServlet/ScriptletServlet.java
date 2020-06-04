package scriptletServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "testScriptSrv", urlPatterns = {"/test_scripts", "/scripts/*"})
public class ScriptletServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer context = req.getRequestURL();
        String[] resource = context.toString().split("/");
        String jsp = resource[resource.length - 1] + ".jsp";
        if (resource[resource.length - 2].equals("scripts")) {
            req.setAttribute("testScriptSrvAttribute", jsp);
            try {
                req.getRequestDispatcher("/scriptJsp/" + jsp).include(req, resp);
            } catch (ServletException s) {
                resp.getWriter().write(s.getMessage());
            }

        }
    }
}
