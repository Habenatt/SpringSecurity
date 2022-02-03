<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />
success!! <br>

${username} is already registered!


User <b>${usernameSessionKey }</b> is logged in ( from session )
<br>
Logged in user = <b>${loggedInUser }</b> ( from response model )
<br>


 <a href="/logout">logout</a>


<jsp:include page="../include/footer.jsp" />





