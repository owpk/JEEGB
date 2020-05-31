package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

    private transient FilterConfig filterConfig;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        httpResp.addHeader("X-CharSet", "UTF-8");
        httpResp.setContentType("text/html; charset=utf-8");

        String[] pages = {"main", "cart", "order", "catalog", "product", "sql", "calc"};

        httpResp.getWriter().write("<br><header>");
        Arrays.stream(pages).forEach(a -> {
            try {
                httpResp.getWriter().print(String.format("<a href=\"/%s\">| %s |</a>", a, a));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        httpResp.getWriter().write("</header></br>");
        filter.doFilter(httpReq, httpResp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
}
