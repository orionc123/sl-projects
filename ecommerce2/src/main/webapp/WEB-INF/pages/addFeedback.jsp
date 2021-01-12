<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Add New Feedback</h1>
<%--@elvariable id="newFeedback" type="com.hcl.model.Feedback"--%>
<form:form modelAttribute="newFeedback">
        <table>
            <tr>
                <td><form:label path="item">Item</form:label>
                    <form:input path="item" required="true" />
                    <form:errors path="item" /></td>
            </tr>
            <tr>
                <td><form:label path="description">Description</form:label>
                    <form:input path="description" required="true" />
                    <form:errors path="description" /></td>
            </tr>
            <tr>
                <td><form:label path="user">User</form:label>
                    <form:input path="user" required="true" />
                    <form:errors path="user" /></td>
            </tr>
        </table>
    <form:button>Add Feedback</form:button>
</form:form>
