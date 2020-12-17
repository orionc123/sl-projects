<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Success</title>
</head>
<body>
<p>Login Success!</p>
welcome <%=session.getAttribute("sessionName")%>
<form>
    <button type="submit" formaction="logout">Logout</button>
</form>
</body>
</html>