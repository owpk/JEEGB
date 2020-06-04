
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Page</title>
</head>
<body>

<header>
    <jsp:include page="menu.jsp"/>
</header>

<% for (int i=0; i<5; i++) { %>
<p>Строка номер <%= i %></p>
<% } %>

<%=request.getAttribute("testAttribute")%>
<%=request.getAttribute("testScriptSrvAttribute")%>
<%=response.getHeader("testHeader")%>

<!-- объявление %!-->
<%!
    public int calc(int a, int b){
        return  a+b;
    }
%>
<%=calc(4,8)%>

<form action="${pageContext.request.contextPath}/scriptJsp/profile.jsp" method="post">
    Имя пользователя: <input type="text" name="user"><br>
    Пароль: <input type="password" name="pass"><br>
    <input type="submit" value="Сохранить">
</form>

</body>
</html>

