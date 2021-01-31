<%@ page import="com.hcl.capstone.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thank You!</title>
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
    <h1 class="display-3">Thank you!</h1>
    <p class="lead">Thank you for shopping at the music store.</p>
    <hr class="my-4">
    <p>Your order will be shipped within 3 business days.</p>
    <p class="lead">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/home" role="button">Home</a>
    </p>
</div>

</body>
</html>
