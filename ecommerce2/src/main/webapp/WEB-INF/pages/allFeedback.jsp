<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Feedback</h1>
<table border="1" width="90%">
    <tr>
        <th>ID</th>
        <th>Item</th>
        <th>Description</th>
        <th>User</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <jsp:useBean id="feedbackList" scope="request" type="java.util.List"/>
    <c:forEach items="${feedbackList}" var="feedback">
        <tr>
            <td>${feedback.id}</td>
            <td>${feedback.item}</td>
            <td>${feedback.description}</td>
            <td>${feedback.user}</td>
            <td><a href="edit-feedback/${feedback.id}">Update</a></td>
            <td><a href="delete-feedback/${feedback.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>