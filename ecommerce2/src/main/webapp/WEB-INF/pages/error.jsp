<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="errorMessage" scope="request" type="java.lang.String"/>
<c:out value="${errorMessage}"/>