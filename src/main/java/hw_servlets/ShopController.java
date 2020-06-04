package hw_servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "shop_ctrl", urlPatterns = {"/shop", "/shop/*"})
public class ShopController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer context = req.getRequestURL();
        String[] resource = context.toString().split("/");
        if (resource[resource.length - 1].equals("shop")) {
            req.getRequestDispatcher("/index.jsp").include(req, resp);
            return;
        }
        String jsp = resource[resource.length - 1] + ".jsp";
        if (resource[resource.length - 2].equals("shop")) {
            try {
                req.getRequestDispatcher("/jsp/" + jsp).include(req, resp);
            } catch (ServletException s) {
                resp.getWriter().write(s.getMessage());
            }

        }
    }
}
