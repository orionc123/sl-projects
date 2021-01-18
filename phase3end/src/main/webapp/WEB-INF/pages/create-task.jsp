<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Task</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<body>
<%--@elvariable id="newTask" type="com.hcl.phase3end.model.Task"--%>
<form:form modelAttribute="newTask">
    <table class="table table-dark">

        <tr>
            <td><form:label path="name">Name</form:label>
                <form:input path="name" required="true"/></td>
        </tr>

        <tr>
            <td><form:label path="startDate">Start Date</form:label>
                <form:input type="date" path="startDate" required="true"/></td>
        </tr>

        <tr>
            <td><form:label path="endDate">End Date</form:label>
                <form:input type="date" path="endDate" required="true"/></td>
        </tr>

        <tr>
            <td><form:label path="description">Description</form:label>
                <form:input path="description" required="true"/></td>
        </tr>

        <tr>
            <td><form:label path="email">Email</form:label>
                <form:input path="email" required="true"/></td>
        </tr>

        <tr>
            <td>
                <form:label path="priority">Priority</form:label>
                <form:select path="priority" required="true">
                    <form:option value="High"/>
                    <form:option value="Medium"/>
                    <form:option value="Low"/>
                </form:select>
        </tr>
    </table>
    <form:button>Add Task</form:button>
</form:form>
</body>
</html>