<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />


<form method="get" action="/registration-url-path/ListAllUsers">

    <button type="submit">ListAllUsers</button>
</form><br>

<form method="get" action="/registration-url-path/userList">
    <input type="text" name="search" value="${search}" placeholder="Enter your First name">
    <button type="submit" >Search</button>
</form><br>


<form method="get" action="/registration-url-path/containsIgnoreCase">

    FirstName : <input type="text" name="firstName" value="${fname}" placeholder="Enter your First name"> <b>OR</b>
    LastName : <input type="text" name="lastName" value="${lname}" placeholder="Enter your LAst name">

    <button type="submit">Contains</button>
</form><br>

<%--<form method="get" action="/registration-url-path/deleteUser?id=${user.id}">
    <button type="delete">delete</button>
</form><br>--%>


<form method="get" action="/registration-url-path/userList" style="border: black solid 2px "><br>
   FirstName : <input type="text" name="firstName" value="${fname}" placeholder="Enter your First name"> <b>AND</b>
  LastName : <input type="text" name="lastName" value="${lname}" placeholder="Enter your LAst name">
    <button type="submit">Search</button><br><br>
</form><br><br>


<form method="get" action="/registration-url-path/userListOR" style="border: black solid 2px "><br>
    FirstName : <input type="text" name="firstName2" value="${fname}"> <b>OR</b>
        LastName : <input type="text" name="lastName2" value="${lname}">
    <button type="submit">Search</button><br><br>
</form><br>



<table border="1">
    <tr>
        <td><b>Id</b></td>
        <td><b>Username</b></td>
        <td><b>Email</b></td>
        <td><b>First Name</b></td>
        <td><b>Last Name</b></td>
        <td><b>Password</b></td>
        <td><b>Edit</b></td>
        <td><b>Delete</b></td>
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
            <td><b><a href="/registration-url-path/deleteUser?id=${user.id}">Delete</a> </b></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../include/footer.jsp" />