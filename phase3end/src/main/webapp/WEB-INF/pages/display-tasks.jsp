<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>All Tasks</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<body>
<table class="table table-dark table-striped" border="1" width="90%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Description</th>
        <th>Email</th>
        <th>Priority</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <jsp:useBean id="taskList" scope="request" type="java.util.List"/>
    <c:forEach items="${taskList}" var="task">
        <tr>
            <td>${task.id}</td>
            <td>${task.name}</td>
            <td>${task.startDate}</td>
            <td>${task.endDate}</td>
            <td>${task.description}</td>
            <td>${task.email}</td>
            <td>${task.priority}</td>
            <td><a href="update-task/${task.id}">Update</a></td>
            <td><a href="delete-task/${task.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a class="btn btn-dark" href="/create-task">Add Task</a>
</body>