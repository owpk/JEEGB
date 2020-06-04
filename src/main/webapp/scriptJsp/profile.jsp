<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>

<jsp:useBean scope="page" class="scriptletServlet.Register" id="profile"/>
<jsp:setProperty property="*" name="profile"/>

Имя пользователя:
<jsp:getProperty property="user" name="profile"/>

Пароль:
<jsp:getProperty property="pass" name="profile"/>

</body>
</html>
