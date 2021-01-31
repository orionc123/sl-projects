<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="bootstrap.min.css">
    <title>Update User</title>
</head>
<body>
<h1>Update User</h1>
<form method="post">
    <fieldset>
        <div class="form-group">
            <label>
                Password:<input type="password" class="form-control" required="required" name="password">
            </label>
        </div>

        <div class="form-group">
            <label>
                Email:<input type="email" class="form-control" required="required" name="email">
            </label>
        </div>
        <div class="form-group">
            <label>
                Phone:<input type="text" class="form-control" required="required" name="phone">
            </label>
        </div>

        <h2>Billing Address:</h2>

        <div class="form-group">
            <label>
                Full Name:<input type="text" class="form-control" required="required" name="fullName">
            </label>
        </div>
        <div class="form-group">
            <label>
                Address:<input type="text" class="form-control" required="required" name="streetName">
            </label>
        </div>
        <div class="form-group">
            <label>
                Apt #:<input type="text" class="form-control" name="aptNumber">
            </label>
        </div>
        <div class="form-group">
            <label>
                City:<input type="text" class="form-control" required="required" name="city">
            </label>
        </div>
        <div class="form-group">
            <label>
                State:<input type="text"  class="form-control" required="required" name="state">
            </label>
        </div>
        <div class="form-group">
            <label>
                Country:<input type="text" class="form-control" required="required" name="country">
            </label>
        </div>
        <div class="form-group">
            <label>
                Zip Code:<input type="number" class="form-control" required="required" name="zip">
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </fieldset>
</form>
</body>
</html>
