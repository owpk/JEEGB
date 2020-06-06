package hw_servlets;

import scriptletServlet.MenuBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@WebServlet(name = "shop_ctrl", urlPatterns = {"/shop", "/shop/*"})
public class ShopController extends HttpServlet {

    private Object[] getRowResource(StringBuffer context) {
        return  Arrays.stream(context.toString().split("/"))
                .filter(x -> x != null && !x.isEmpty())
                .map(String::trim)
                .toArray();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object[] resource = getRowResource(req.getRequestURL());
        if (resource[resource.length - 1].equals("shop")) {
            req.getRequestDispatcher("/main.jsp").include(req, resp);
            return;
        }

        String root = (String) resource[2];
        String page = (String) resource[3];
        String jsp = page + ".jsp";
        if (root.equals("shop")) {
            try {

                if (page.equals(MenuBean.PagesSet.CATALOG.getName()))
                    req.setAttribute("cat_bean", new HibernateCatalogRunner());

                req.setAttribute("pageName", page);
                req.getRequestDispatcher("/jsp/" + jsp).include(req, resp);
            } catch (ServletException s) {
                resp.getWriter().write(s.getMessage());
            }
        }
    }



}
