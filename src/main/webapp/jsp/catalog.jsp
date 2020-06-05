<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Page</title>
</head>
<body>
<%@include file="menu.jsp" %>
<h1><%=request.getAttribute("pageName")%></h1>
<div class="container p-3 my-3 border">
    <h3>Available products</h3>
    <div class="row mb-3">
        <div class="col-4 themed-grid-col">
            <table class="table table-bordered">
                <thead class="thead">
                    <tr>
                        <td>Name</td>
                        <td>Cost</td>
                        <td>Description</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cat_bean.catalogModel}" var="product">
                        <tr>
                            <td>${product.getName()}</td>
                            <td>${product.getCost()}</td>
                            <td>${product.getDescription()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
