
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Page</title>
</head>
<body>
<% for (int i=0; i<5; i++) { %>
<p>Строка номер <%= i %></p>
<% } %>

<%=request.getAttribute("testAttribute")%>
<%=request.getAttribute("testScriptSrvAttribute")%>
<%=response.getHeader("testHeader")%>
</body>
</html>

