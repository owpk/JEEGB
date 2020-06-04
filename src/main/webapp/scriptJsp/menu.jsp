<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<ul style="list-style-type: none">

    <jsp:useBean id="menuList" class="scriptletServlet.MenuBean" scope="request"/>

    <ul>
        <c:forEach items="${menuList.menuList}" var="page">
            <li><a href="/${page}">${page}</a></li>
        </c:forEach>
    </ul>

    <%=request.getParameter("one")%>
    <%=request.getParameter("two")%>


</ul>
