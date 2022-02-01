<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<form method="get"  action="/registration-url-path/registerSubmit">

    <label for="fname" style="width: 14%;"  > <b>First name:</b></label>
    <input type="text" id="fname" name="firstName" value="${formBeanKey.firstName}" placeholder="Enter your First name"><br>

    <label for="lname" style="width: 14%;" > <b>Last name:</b></label>
    <input type="text" id="lname" name="lastName" value="${formBeanKey.lastName}" placeholder="Enter your Last name"><br>

    <label for="email" style="width: 14%;"><b>email:</b></label>
    <input type="text" id="email" name="email" value="${formBeanKey.email}" placeholder="Enter your email"><br>

    <label for="age" style="width: 14%;"><b>Age:</b></label>
    <input type="number" id="age" name="age" value="${formBeanKey.age}" placeholder="Enter your age"><br>


    <label for="pass" style="width: 14%;"><b>Password:</b></label>
    <input type="text" id="pass" name="password" value="${formBeanKey.password}" placeholder="Enter your Password"><br>

    <label for="Cpass" style="width: 14%;"><b>confirm Password:</b></label>
    <input type="text" id="Cpass" name="confirmPassword" value="${formBeanKey.confirmPassword}" placeholder="Confirm your Password"><br>

    <input id="add" type="submit" name="submit"  value="Register" /><br>



</form>

<div style="color: red">
<c:forEach  items="${formBeanKey.errorMessages}" var="message" varStatus="status">
    <span style="color: red">${message}</span><br>
</c:forEach>
</div>

<jsp:include page="../include/footer.jsp" />
