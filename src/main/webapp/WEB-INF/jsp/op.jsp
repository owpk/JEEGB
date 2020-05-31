<%--
  Created by IntelliJ IDEA.
  User: vzvz4
  Date: 29.05.2020
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Page</title>
</head>
<body>
<%@include file="menu.jsp"%>
<h1>Это главная страница нашего приложения</h1>
<div><strong>URL-адрес страницы:</strong> <%=request.getRequestURI()%></div>
<div><strong>ID сессии:</strong> <%=session.getId()%></div>
<%-- Создание атрибута сессии --%>
<%
    session.setAttribute("hello", "Привет");
%>
</body>
</html>
