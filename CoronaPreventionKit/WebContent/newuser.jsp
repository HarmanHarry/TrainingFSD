<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<h3><u>Add New User</u></h3>
</br>
	<form action="createUser" method="post">
		<table cellspacing="5px" cellpadding="5px">

			<tr>
				<td><label>Full Name</label></td>
				<td><input type="text" name="uname" required /></td>
			</tr>
			<tr>
				<td><label>Email Id</label></td>
				<td><input type="text" name="uemail" required /></td>
			</tr>
			<tr>
				<td><label>Contact Number </label></td>
				<td><input type="text" name="ucontactNumber" required /></td>
			</tr>
		</table>
		</br>
		<button>Submit</button>
	</form>
	</br>
	</br>
	</br>
	<jsp:include page="footer.jsp" />
</body>
</html>