<%@ page import="com.hcl.capstone.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
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


<table class="table table-dark table-striped" border="1" width="90%">
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Full Name</th>
        <th>Street Name</th>
        <th>Unit</th>
        <th>City</th>
        <th>State</th>
        <th>Country</th>
        <th>Zip</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <%
        List<User> users = (List<User>) session.getAttribute("allUsers");
        for (User u : users) {
            if(!u.getUsername().equals("admin")){

    %>
    <tr style="text-align: center">
        <td><%=u.getUsername()%></td>
        <td><%=u.getPassword()%></td>
        <td><%=u.getEmail()%></td>
        <td><%=u.getPhone()%></td>
        <td><%=u.getFullName()%></td>
        <td><%=u.getStreetName()%></td>
        <td><%=u.getAptNumber()%></td>
        <td><%=u.getCity()%></td>
        <td><%=u.getState()%></td>
        <td><%=u.getCountry()%></td>
        <td><%=u.getZip()%></td>
        <td><a href="update/<%=u.getUsername()%>">Update</a></td>
        <td><a href="delete/<%=u.getUsername()%>">Delete</a></td>
    </tr>
    <%}}%>
</table>
</body>
</html>
