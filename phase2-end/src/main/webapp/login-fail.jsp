<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Failed</title>
</head>
<body>
<p>Login failed: <%=session.getAttribute("errorMessage") %></p>
<p>New User? Create an account!</p>
<form>
    <button type="submit" formaction="registration.html">Create Account</button>
    <button type="submit" formaction="index.jsp">Return to Dashboard</button>
</form>
</body>
</html>
