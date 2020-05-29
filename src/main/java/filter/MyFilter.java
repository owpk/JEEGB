package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

    private transient FilterConfig filterConfig;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        httpResp.addHeader("X-CharSet", "UTF-8");
        httpResp.setContentType("text/html; charset=utf-8");
        httpResp.getWriter().write("<header><a href=\"/main\">| main |</a>");
        httpResp.getWriter().write("<a href=\"/cart\">| cart |</a>");
        httpResp.getWriter().write("<a href=\"/order\">| order |</a>");
        httpResp.getWriter().write("<a href=\"/catalog\">| catalog |</a>");
        httpResp.getWriter().write("<a href=\"/product\">| product |</a>");
        httpResp.getWriter().write("<a href=\"/sql\">| sql |</a></header>");
        filter.doFilter(httpReq, httpResp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
}
