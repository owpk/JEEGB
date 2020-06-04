<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.io.IOException" %>


<ul style="list-style-type: none">
    <%!

        String[] pages = {"main", "cart", "order", "catalog",
                "product", "sql", "calc", "po", "test_scripts"};
    %>
    <%
        Arrays.stream(pages).forEach(a -> {
            try {
                response.getWriter().write(String.format("<a href=\"/%s\">| %s |</a>", a, a));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    %>
    <li style="display: inline-block"><a href="index.jsp">Главная</a></li>
    <li style="display: inline-block"><a href="catalog.jsp">Каталог</a></li>
</ul>
