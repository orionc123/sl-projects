<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="bootstrap.min.css">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form method="post">
    <div class="form-group">
        <label>
            Username:<input type="text" class="form-control" required="required" name="username">
        </label>
    </div>

    <div class="form-group">
        <label>
            Password:<input type="password" class="form-control" required="required" name="password">
        </label>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form>
</body>
</html>
