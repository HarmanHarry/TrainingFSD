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
<jsp:include page="header.jsp"/>

<div>
	<h2><u>Admin Login</u></h2>
	<form action="login" method="post">
		<div>
			<div><label for="uname">Enter Username</label> </div>
			<div><input type="text" id="uname" name="uname" required> </div>
		</div>
		</br>
		<div>
			<div><label for="password">Enter Password</label> </div>
			<div><input type="password" id="password" name="password" required> </div>
		</div>
		<div>
		</br>
			<div><input type="submit" value="Login"> </div>
		</div>
	</form>
	</br>
	<c:if test="${errMsg != null }">
		<p>${errMsg }</p>
	</c:if>
</div>
<hr/>
<div>
</br>
	<a href="newuser.jsp"><button>Create Corona Kit</button></a>
	
</div>
</br>


	<jsp:include page="footer.jsp"/>
</body>
</html>