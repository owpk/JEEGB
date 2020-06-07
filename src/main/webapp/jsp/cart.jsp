<%@page contentType="text/html" pageEncoding="UTF-8" %>
<body>
<%@include file="menu.jsp" %>
<h1><%=request.getAttribute("pageName")%></h1>
<div class="container p-3 my-3 border">
    <div class="row mb-3">
        <div class="col-4 themed-grid-col">.col-4</div>
        <div class="col-4 themed-grid-col">.col-4</div>
        <div class="col-4 themed-grid-col">.col-4</div>
    </div>

    <div class="row mb-3">
        <div class="col-sm-4 themed-grid-col">.col-sm-4</div>
        <div class="col-sm-4 themed-grid-col">.col-sm-4</div>
        <div class="col-sm-4 themed-grid-col">.col-sm-4</div>
    </div>
</div>
</body>
</html>
