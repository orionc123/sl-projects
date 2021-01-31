<%@ page import="com.hcl.capstone.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="bootstrap.min.css">
    <title>Music Store</title>
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

<%--CAROUSEL--%>
<div id="home">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100"
                     src="https://www.dailyhindnews.com/wp-content/uploads/2021/01/1610195313_Deal-Save-170-on-the-Jabra-Evolve-2-85-headphones-1200x720.jpg"
                     alt="First slide">
                <div class="carousel-caption d-none d-md-block">
                    <h1>Music Store</h1>
                    <p>It's music to your ears</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100"
                     src="https://serenademagazine.com/wp-content/uploads/2020/07/hands-4062071_1280-1200x720.jpg"
                     alt="Second slide">
                <div class="carousel-caption d-none d-md-block">
                    <h1>Music Store</h1>
                    <p>It's music to your ears</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100"
                     src="https://i.guim.co.uk/img/media/af01d3289a14389fcbfa8440f6d53bff3f5ac0cd/0_145_2560_1536/master/2560.jpg?width=1200&quality=85&auto=format&fit=max&s=a9feace9fa8165c84d16ef574f746d60"
                     alt="Third slide">
                <div class="carousel-caption d-none d-md-block">
                    <h1>Music Store</h1>
                    <p>It's music to your ears</p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<br>
<!--GRID-->
<div id="menu">
    <div class="container">
        <div class="row">
            <div class="col-4">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" height="170" width="284"
                         src="https://tse1.mm.bing.net/th/id/OIP.FnOOse8B3x2ZKeEsAtZuuwHaE7?w=288&h=191&c=7&o=5&dpr=1.5&pid=1.7">
                    <div class="card-body">
                        <h5 class="card-title">Instruments</h5>
                        <p class="card-text">For the creators.</p>
                        <button class="btn btn-primary" onclick="window.location.href='/products'">View Products</button>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" height="170" width="284"
                         src="data:image/png;base64,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"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Songs</h5>
                        <p class="card-text">For the consumers.</p>
                        <button class="btn btn-primary" onclick="window.location.href='/products'">View Products</button>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" height="170" width="284"
                         src="data:image/jpeg;base64,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">
                    <div class="card-body">
                        <h5 class="card-title">Vinyl</h5>
                        <p class="card-text">For the cultured.</p>
                        <button class="btn btn-primary" onclick="window.location.href='/products'">View Products</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<hr>
<footer id="footer" align="center">
    Developed by Orion Carroll © 2021
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
</script>
</body>
</html>
