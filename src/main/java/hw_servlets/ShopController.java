package hw_servlets;

import scriptletServlet.MenuBean;

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
        String page = resource[resource.length - 1];
        String jsp = page + ".jsp";
        if (resource[resource.length - 2].equals("shop")) {
            try {
                if (page.equals(MenuBean.PagesSet.CATALOG.getName()))
                    req.setAttribute("cat_bean", new HibernateCatalogRunner());
                req.setAttribute("pageName" , page);
                req.getRequestDispatcher("/jsp/" + jsp).include(req, resp);
            } catch (ServletException s) {
                resp.getWriter().write(s.getMessage());
            }

        }
    }
}
