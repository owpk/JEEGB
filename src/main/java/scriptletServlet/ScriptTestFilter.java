package scriptletServlet;

import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(urlPatterns = {"/test_scripts/*", "/scripts/*"})
public class ScriptTestFilter implements Filter {

    private transient FilterConfig filterConfig;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;

        String[] pages = {"test1", "forward"};
        httpResp.getWriter().write("<br>Scriptlets list</br>");
        httpResp.getWriter().write("<br><header>");

        Arrays.stream(pages).forEach(a -> {
            try {
                httpResp.getWriter().print(String.format("<a href=\"/scripts/%s\">| %s |</a>", a, a));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        httpResp.getWriter().write("</header></br>");
        httpReq.setAttribute("testAttribute", "testAttribute@vz");
        httpResp.addHeader("testHeader", "testHeader@vz");
        filter.doFilter(httpReq, httpResp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
}
