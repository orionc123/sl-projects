<%@ page import="com.hcl.capstone.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hcl.capstone.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Product Inventory</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<%--NAV--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Music Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
            aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/home">Home
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/products">Products</a>
            </li>
        </ul>

        <%--        RIGHT SIDE--%>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Welcome <%=((User) session.getAttribute("currentUser")).getUsername()%>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin">Admin</a>
            </li>
        </ul>

    </div>
</nav>

<table class="table table-dark table-striped" border="1" width="90%">
    <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Category</th>
        <th>Condition</th>
        <th>Price</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <%
        List<Product> products = (List<Product>) session.getAttribute("allProducts");
        for (Product p : products) {
    %>
    <tr style="text-align: center">
        <td><img style="width: 75px; height: 75px" src="<%=p.getImageLink()%>"
                 alt="Product Image"/>
        <td><%=p.getName()%>
        </td>
        <td><%=p.getCategory()%>
        </td>
        <td><%=p.getCondition()%>
        </td>
        <td><%=p.getPrice()%>
        </td>
        <td><a href="update-prod/<%=p.getName()%>">Update</a></td>
        <td><a href="delete-prod/<%=p.getName()%>">Delete</a></td>
    </tr>
    <%}%>
</table>
<a class="btn btn-dark" href="${pageContext.request.contextPath}/create-prod">Add Product</a>
</body>
</html>
