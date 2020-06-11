<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
<%@include file="menu.jsp"%>
<h1>Это главная страница нашего приложения</h1>
<div><strong>URL-адрес страницы:</strong> <%=request.getRequestURI()%></div>
<div><strong>ID сессии:</strong> <%=session.getId()%></div>
<%
    session.setAttribute("hello", "Привет");
%>
</body>
</html>
