<%@ page import="com.hcl.capstone.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
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

<h1>Checkout</h1>
<p>Confirm Billing Address:</p>
<form method="post">
    <fieldset>
<div class="form-group">
    <label>
        Full Name:<input type="text" class="form-control" required="required" name="fullName" value="<%=((User)session.getAttribute("currentUser")).getFullName()%>">
    </label>
</div>
<div class="form-group">
    <label>
        Address:<input type="text" class="form-control" required="required" name="streetName" value="<%=((User)session.getAttribute("currentUser")).getStreetName()%>">
    </label>
</div>
<div class="form-group">
    <label>
        Apt #:<input type="text" class="form-control" name="aptNumber" value="<%=((User)session.getAttribute("currentUser")).getAptNumber()%>">
    </label>
</div>
<div class="form-group">
    <label>
        City:<input type="text" class="form-control" required="required" name="city" value="<%=((User)session.getAttribute("currentUser")).getCity()%>">
    </label>
</div>
<div class="form-group">
    <label>
        State:<input type="text"  class="form-control" required="required" name="state" value="<%=((User)session.getAttribute("currentUser")).getState()%>">
    </label>
</div>
<div class="form-group">
    <label>
        Country:<input type="text" class="form-control" required="required" name="country" value="<%=((User)session.getAttribute("currentUser")).getCountry()%>">
    </label>
</div>
<div class="form-group">
    <label>
        Zip Code:<input type="number" class="form-control" required="required" name="zip" value="<%=((User)session.getAttribute("currentUser")).getZip()%>">
    </label>
</div>
<button type="submit" class="btn btn-primary">Next</button>
</fieldset>
</form>
</body>
</html>
