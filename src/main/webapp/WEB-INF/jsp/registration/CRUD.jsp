<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<form method="GET" action="/registration-url-path/CRUDOperations">
    <input type="hidden" name="id" value="${formBeanKey.id}">


    <label for="uname" style="width: 14%;"  > <b>User name:</b></label>
    <input type="text" id="uname" name="userName" value="${formBeanKey.userName}" placeholder="Enter your User name"><br>

    <label for="fname" style="width: 14%;"  > <b>First name:</b></label>
    <input type="text" id="fname" name="firstName" value="${formBeanKey.firstName}" placeholder="Enter your First name"><br>

    <label for="lname" style="width: 14%;" > <b>Last name:</b></label>
    <input type="text" id="lname" name="lastName" value="${formBeanKey.lastName}" placeholder="Enter your Last name"><br>

    <label for="email" style="width: 14%;"><b>email:</b></label>
    <input type="text" id="email" name="email" value="${formBeanKey.email}" placeholder="Enter your email"><br>

    <label for="phone" style="width: 14%;"><b>Phone:</b></label>
    <input type="text" id="phone" name="phone" value="${formBeanKey.phone}" placeholder="Enter your Telephone Number"><br>

    <label for="age" style="width: 14%;"><b>Age:</b></label>
    <input type="number" id="age" name="age" value="${formBeanKey.age}" placeholder="Enter your age"><br>

    <label for="pass" style="width: 14%;"><b>Password:</b></label>
    <input type="text" id="pass" name="password" value="${formBeanKey.password}" placeholder="Enter your Password"><br>

    <label for="Cpass" style="width: 14%;"><b>confirm Password:</b></label>
    <input type="text" id="Cpass" name="confirmPassword" value="${formBeanKey.confirmPassword}" placeholder="Confirm your Password"><br>
   <%-- <input id="add" type="submit" name="submit"  value="register" />
    <input id="update" type="submit" name="submit"  value="Update" />--%>
    <input id="delete" type="submit" name="submit"  value="delete" /><br><Br>

</form><br>

<script>

    function deleteRow(obj) {

        var index = obj.parentNode.parentNode.rowIndex;
        var table = document.getElementById("myTableData");
        table.deleteRow(index);

    }



</script>

<form method="get" action="/registration-url-path/CRUDOperations">
    <input type="text" name="search">
    <button type="submit">ListUsersBFirstName</button>
</form><br>



<form method="get" action="/registration-url-path/CRUDOperations" style="border: black solid 2px "><br>
    FirstName : <input type="text" name="firstName" value="${formBeanKey.firstName}"> <b>AND</b>
    LastName : <input type="text" name="lastName" value="${formBeanKey.firstName}">
    <button type="submit">Search</button><br>
</form><br><br>



<table border="1" id="myTableData">



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
            <td><b><a href="/registration-url-path/CRUDOperations?id=${user.id}">Edit</a> </b></td>
            <td><input type="button" value = "Delete" onClick="Javacsript:deleteRow(this)"></td>
        </tr>
    </c:forEach>
</table>




<br>

<div style="color: red">
    <c:forEach  items="${formBeanKey.errorMessages}" var="message" varStatus="status">
        <span style="color: red">${message}</span><br>
    </c:forEach>
</div>

<jsp:include page="../include/footer.jsp" />
