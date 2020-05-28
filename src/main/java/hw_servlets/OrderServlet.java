package hw_servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "order_srv", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("PageName", "order");
        resp.getWriter().write("<br>Page: " + resp.getHeader("PageName") + "</br>");
        resp.getWriter().write("<br>FilterHeader: " + resp.getHeader("X-CharSet") + "</br>");
    }
}
