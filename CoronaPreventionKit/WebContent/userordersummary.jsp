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
	<h3><u>Order Summary </u></h3>
	</br>
	
	<table border="0" cellspacing="7px" cellpadding="7px">
		<tr>
			<th><h3>TOTAL BILL AMOUNT - </h3></th>
			<td><h3> Rs ${orderSummary.totalCost}</h3></td>
		</tr>
	</table>
	
	<table border="1" cellspacing="2px" cellpadding="10px">
		<h4>PRODUCTS IN YOUR KIT</h4>
		<tr>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Quantity</th>
			<th>Amount</th>
		</tr>
		<c:forEach items="${orderSummary.kitDetails}" var="kitDetail">
			<c:if test="${kitDetail.quantity!=0}">
				<tbody>

					<td>${kitDetail.productName}</td>
					<td>${kitDetail.productDesc}</td>
					<td>${kitDetail.quantity}</td>
					<td>${kitDetail.amount}</td>

				</tbody>
			</c:if>
		</c:forEach>
	</table>
	
	
	

	<table border="1" cellspacing="2px" cellpadding="10px">
		<tr>
			<h4>YOURS DETAILS</h4>
			</hr>
		</tr>
		<tr>
			<td>Name</td>
			<td>${orderSummary.user.personName}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${orderSummary.user.email}</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${orderSummary.user.deliveryAddress}</td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td>${orderSummary.user.contactNumber}</td>
		</tr>
		<tr>
			<td>OrderDate</td>
			<td>${orderSummary.user.orderDate}</td>
		</tr>
		</tr>
	</table>
	</br>
	<p align="center"><strong>Thank You For Shopping With Us!</strong></p>
	

	<jsp:include page="footer.jsp" />

</body>
</html>