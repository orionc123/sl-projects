<%@ page import="com.hcl.capstone.model.User" %>
<%@ page import="com.hcl.capstone.model.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<%--NAV--%>
<%if (session.getAttribute("currentUser") == null) {%>
<%--GUEST--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Music Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
            aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor01">
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
                <a class="nav-link" href="${pageContext.request.contextPath}/login">Welcome Guest</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/register">Register</a>
            </li>
        </ul>

    </div>
</nav>
<% } else if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {%>
<%--ADMIN--%>
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
<% } else {%>
<%--USER--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Music Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
            aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor03">
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
                <a class="nav-link" href="${pageContext.request.contextPath}/cart">Cart</a>
            </li>
        </ul>

    </div>
</nav>
<% }%>


<input type="text" id="searchBar" onkeyup="filterAllColumns()" placeholder="Search for products.."
       title="Type in a name">

<table id="productTable" class="table table-dark table-striped" border="1" width="90%">
    <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Category</th>
        <th>Condition</th>
        <th>Price</th>
        <th>Add to Cart</th>
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
        <td>
            <form method="post">
                <button class="btn-success" type="submit" value="<%=p.getName()%>" name="nameOfAdded">Add to Cart
                </button>
            </form>
        </td>


    </tr>
    <%}%>
</table>
<a class="btn btn-dark" href="${pageContext.request.contextPath}/cart">View Cart</a>

<%--search filter--%>
<script>
    function filterAllColumns() {
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("searchBar");
        filter = input.value.toUpperCase();
        table = document.getElementById("productTable");
        tr = table.getElementsByTagName("tr");
        for (i = 1; i < tr.length; i++) {
            td = tr[i];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
</body>
</html>