package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "post_srv", urlPatterns = "/po")
    public class PostServlet extends HttpServlet {
    private String url;

    @Override
    public void init() throws ServletException {
        url = "/WEB-INF/";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath().equals("/po")) {
            req.getRequestDispatcher("/home.jsp").include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, String[]> map = req.getParameterMap();
            map.forEach((x, y) -> {
                try {
                    resp.getWriter().write("<b>" + x + ":" + Arrays.asList(y) + "</b>");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
    }
}
