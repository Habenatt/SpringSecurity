<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<h2> LOGIN from FORM </h2>

<form method="get"  action="/logoutFormSubmit2">
             Username : <input type="text" name="usernameFromForm"><br>
             Password : <input type="password" name="passwordFromForm"> <br>




<input id="login" type="submit" name="Login"  value="Submit">

</form>





<jsp:include page="../include/footer.jsp" />