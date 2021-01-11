<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit User</h1>

<%--@elvariable id="user" type="com.hcl.model.User"--%>
<form:form method="post" modelAttribute="user">
    <table border="0" cellpadding="5">
        <tr>
            <td>Name: </td>
            <td>${user.name}
                <form:hidden path="name"/>
            </td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><form:input path="pass" /></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>