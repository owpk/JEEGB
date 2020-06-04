package servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "BasicServlet", urlPatterns = "/home")
public class BasicServlet implements Servlet {
    private static Logger logger = LoggerFactory.getLogger(BasicServlet.class);
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        logger.info("init servlet " + getServletInfo());
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        PrintWriter pw = servletResponse.getWriter();
//        pw.print("Servlet content");
        servletRequest.setAttribute("header", "Hello");
        config.getServletContext().getRequestDispatcher("/post").include(servletRequest, servletResponse);
        logger.info("New request");
    }

    @Override
    public String getServletInfo() {
        return "Basic servlet";
    }

    @Override
    public void destroy() {
        logger.info("Destroy servlet " + getServletInfo());
    }
}
