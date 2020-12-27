<%@ page import="com.hcl.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success</title>
</head>
<body>
<p>Login Success!</p>
Welcome <%=((User)session.getAttribute("user")).getUsername()%>
<br>
<%= "Your email address is: " + ((User)session.getAttribute("user")).getEmail()%>
<form>
    <button type="submit" formaction="logout">Logout</button>
</form>
</body>
</html>
