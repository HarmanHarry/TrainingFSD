<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Home</title>
</head>
<body>
<div>
<jsp:include page="header.jsp"/>
<hr/>
	<h2>Admin Login</h2>
	<form action="login" method="post">
		<div>
			<div><label for="uname">Enter Username</label> </div>
			<div><input type="text" id="uname" name="uname" required> </div>
		</div>
		<div>
			<div><label for="password">Enter Password</label> </div>
			<div><input type="password" id="password" name="password" required> </div>
		</div>
		<div>
			<div><input type="submit" value="Login"> </div>
		</div>
	</form>
</div>
<hr/>
<div>
	<a href="user?action=newuser"><button>Create Corona Kit</button></a>
</div>
</br>
<c:if test="${errMsg != null }">
		<p><strong>${errMsg }</strong></p>
	</c:if>

<hr/>	

	<jsp:include page="footer.jsp"/>
</body>
</html>