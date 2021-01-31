<%@ page import="com.hcl.capstone.model.User" %>
<%@ page import="com.hcl.capstone.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
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


<div class="jumbotron">
    <h1 class="display-3">Order Confirmation</h1>
    <p class="lead">Billing Address:</p>
    <p class="lead"><%=((User)session.getAttribute("currentUser")).getStreetName() + " " + ((User)session.getAttribute("currentUser")).getAptNumber()%></p>
   <p class="lead">
       <%=((User)session.getAttribute("currentUser")).getCity() + " " + ((User)session.getAttribute("currentUser")).getState() + " " + ((User)session.getAttribute("currentUser")).getCountry() + " " + ((User)session.getAttribute("currentUser")).getZip()%>
   </p>
    <hr class="my-4">
</div>

<table class="table table-dark table-striped"border="1" width="90%">
    <tr >
        <th>Name</th>
        <th>Price</th>
    </tr>
    <%
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        double total = 0;
        for (Product p : cart) {
            total += p.getPrice();
    %>
    <tr style="text-align: center">
        <td><%=p.getName()%>
        </td>
        <td><%=p.getPrice()%>
        </td>
    </tr>
    <%}%>

    <tr>
        <td>Total:</td>
        <td>$<%=total%></td>
    </tr>
</table>
<form method="post">
    <button class="btn-success" type="submit">Confirm and Place Order</button>
</form>
</body>
</html>
