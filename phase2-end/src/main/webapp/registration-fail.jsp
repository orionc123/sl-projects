<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration Failed</title>
</head>
<body>
<%=session.getAttribute("errorMessage")%>
<br>
<br>
<form>
    <input type="button" value="Return" onclick="<%session.invalidate();%> history.back()"/>
</form>
</body>
</html>