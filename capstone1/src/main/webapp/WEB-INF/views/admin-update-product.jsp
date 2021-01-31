<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<h1>Update Product</h1>
<form method="post">
    <fieldset>
        <div class="form-group">
            <label>
                Image URL:<input type="text" class="form-control" name="imageLink">
            </label>
        </div>

        <div class="form-group">
            <label>
                Category:<select name="category" required="required" class="form-control">
                <option value="instrument">Instrument</option>
                <option value="song">Song</option>
                <option value="vinyl">Vinyl</option>
            </select>
            </label>
        </div>
        <div class="form-group">
            <label>
                Condition:<select name="condition" required="required" class="form-control">
                <option value="new">New</option>
                <option value="like new">Like New</option>
                <option value="used">Used</option>
            </select>
            </label>
        </div>
        <div class="form-group">
            <label>
                Price:<input type="number" class="form-control" required="required" name="price">
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Update Product</button>
    </fieldset>
</form>
</body>
</html>
