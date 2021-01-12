<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Update Feedback</h1>
<%--@elvariable id="feedback" type="com.hcl.model.Feedback"--%>
<form:form modelAttribute="feedback">
    <table>
        <tr>
            <td><form:label path="id">ID</form:label>
                <form:input path="id" required="true" readonly="true"/>
                <form:errors path="id"/></td>
        </tr>

        <tr>
            <td><form:label path="item">Item</form:label>
                <form:input path="item" required="true"/>
                <form:errors path="item"/></td>
        </tr>

        <tr>
            <td><form:label path="description">Description</form:label>
                <form:input path="description" required="true"/>
                <form:errors path="description"/></td>
        </tr>

        <tr>
            <td><form:label path="user">User</form:label>
                <form:input path="user" required="true"/>
                <form:errors path="user"/></td>
        </tr>
    </table>
    <form:button>Edit Feedback</form:button>
</form:form>