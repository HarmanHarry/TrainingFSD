<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
</head>
<body>
<jsp:include page="header.jsp" />
	</br>
	<h3><u>Delivery Address</u></h3>
	<form action="userOrderSummary" method="post">
		</br>
		</br>

			<label>Please provide the full Delivery Address:</label>
			</br>
			<textarea name="deladdress" rows="6" cols="50"  required></textarea>

		</br>
		</br>
		<button>Place Order</button>		
	</form>
	
		</br>
		</br>
		</br>
	<jsp:include page="footer.jsp" />
</body>
</html>