<%@ page import="beans.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product Details</title>
</head>
<body>
    <h1>Product details:</h1>
    <ul>
        <li><p><b>Name:</b>
            <%= ((Product)session.getAttribute("product")).getName()%>
        </p></li>
        <li><p><b>Brand:</b>
            <%= ((Product)session.getAttribute("product")).getBrand()%>
        </p></li>
        <li><p><b>Description:</b>
            <%= ((Product)session.getAttribute("product")).getDescription()%>
        </p></li>
        <li><p><b>Price:</b>
            <%= ((Product)session.getAttribute("product")).getPrice()%>
        </p></li>
    </ul>
<form>
    <button formaction="index.jsp">Return</button>
</form>
</body>
</html>
