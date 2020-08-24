<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(user)</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<h3><strong><u>Avaliable Products</u></strong></h3>
</br>
<form action="userShowKit" method="post">
	<c:choose>
		<c:when test="${prods == null || prods.isEmpty() }">
			<p>No Products Available</p>
		</c:when>
		<c:otherwise>
		<p>Select the Required Products and Add to Kit</p>
			<table border="1" cellspacing="2px" cellpadding="8px">
				<tr>
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Select Product</th>
				</tr>
				<c:forEach items="${prods }" var="prod">
					<tr>
						<td>${prod.productName }</td>
						<td>${prod.productDescription }</td>
						<td>${prod.productCost }</td>
						<td><input type="number" name="quantity" min="0" value="0"/></td>
						<td><input type="checkbox" name="prods" value="${prod.id }"/></td>
					</tr> 
				</c:forEach>
			</table>
				</br>									
					<button>ADD TO KIT</button>
								
		</c:otherwise>
	</c:choose>
				</form>
			
	
	<jsp:include page="footer.jsp" />
</html>