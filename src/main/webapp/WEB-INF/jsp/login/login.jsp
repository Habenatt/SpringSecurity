
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<%--<jsp:include page="../include/header.jsp">--%>

<form method="get"  action="/loginSubmit">

    <h1 style="color:red">${errorMessage}</h1>
             Username : <input type="text" name="username"><br>
             Password : <input type="password" name="password"> <br>



<input id="login" type="submit" name="Login"  value="Submit">

</form>



 <%--<jsp:include page="../include/footer.jsp">--%>
<jsp:include page="../include/footer.jsp" />

