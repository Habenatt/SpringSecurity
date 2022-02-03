<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<form method="get" action="/registration-url-path/userList">
    <input type="text" name="search">
    <button type="submit">Search2</button>
</form>


<form method="get" action="/registration-url-path/userList">
    <input type="text" name="firstName" value="${formBeanKey.firstName}">
    <input type="text" name="lastName" value="${formBeanKey.firstName}">
    <button type="submit">Search</button>
</form>


<table border="1">
    <tr>
        <td><b>Id</b></td>
        <td><b>Username</b></td>
        <td><b>Email</b></td>
        <td><b>First Name</b></td>
        <td><b>Last Name</b></td>
        <td><b>Password</b></td>
        <td><b>Edit</b></td>
    </tr>
    <c:forEach items="${userListKey}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.password}</td>
            <td><b><a href="/registration-url-path/register?id=${user.id}">Edit</a> </b></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../include/footer.jsp" />