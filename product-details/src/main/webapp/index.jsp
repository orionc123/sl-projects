<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enter Product Details</title>
    <style>
        label{
            display: inline-block;
            float: left;
            clear: left;
            width:80px;
            text-align: left;
        }
        input {
            display: inline-block;
            float: left;
        }
    </style>
</head>
<body>
<p>Enter the product details in this form:</p>
<form action="product-servlet" method="POST">
    <label>Name:</label><input type="text" name="name">
    <br/>
    <label>Brand:</label><input type="text" name="brand"/>
    <br/>
    <label>Description:</label>
    <input type="text" name="description"/>
    <br/>
    <label>Price:</label><input type="text" name="price"/>
    <br>
    <br>
    <button type="submit">Submit - View Product</button>
</form>
</body>
</html>