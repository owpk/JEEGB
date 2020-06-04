package filter;

import scriptletServlet.MenuBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


//@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

    private transient FilterConfig filterConfig;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        httpResp.addHeader("X-CharSet", "UTF-8");
        httpResp.setContentType("text/html; charset=utf-8");

        httpResp.getWriter().write("<header><ul>");
        MenuBean menuBean = new MenuBean();
        PrintWriter pw = httpResp.getWriter();
        menuBean.getMenuList().forEach(a ->
                pw.print(String.format("<li><a href=\"/%s\">| %s |</a></li>", a, a)));
        httpResp.getWriter().write("</ul></header>");
        filter.doFilter(httpReq, httpResp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
}
