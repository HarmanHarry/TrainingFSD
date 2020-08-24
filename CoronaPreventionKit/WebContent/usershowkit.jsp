<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-My Kit(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<h3><strong><u>User Kit Details</u></strong></h3>
</br>
	<c:choose>
		<c:when test="${KitDetails == null || KitDetails.isEmpty() }">
			<p>No Products Available in Kit</p>
			<p><a href="userListProduct">Click here </a>to Add the Products in Kit.</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="2px" cellpadding="8px">
				<tr>
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Amount</th>
				</tr>
				<c:forEach items="${KitDetails }" var="kitDetail">
					<tr>
						<td>${kitDetail.productName }</td>
						<td>${kitDetail.productDesc }</td>
						<td>${kitDetail.productCost }</td>
						<td>${kitDetail.quantity }</td>
						<td>${kitDetail.amount }</td>
					</tr> 
				</c:forEach>
			</table>
			
			</br>
			<div>
				<a href="userListProduct"><button>MODIFY KIT</button></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="userplaceorder.jsp"><button>PLACE ORDER</button></a>
				</div>
			</br>

		</c:otherwise>
	</c:choose>
	
									
			
								


	<jsp:include page="footer.jsp"/>
</body>
</html>