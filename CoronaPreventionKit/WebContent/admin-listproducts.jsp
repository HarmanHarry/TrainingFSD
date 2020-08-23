<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<nav><a href="admin-newproduct.jsp">ADD NEW PRODUCT</a></nav>
</br>
<c:choose>
		<c:when test="${prods == null || prods.isEmpty() }">
			<p>No Products Available</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Product#</th>
					<th>Name</th>
					<th>Description</th>
					<th>Cost</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${prods }" var="prod">
					<tr>
						<td>${prod.id }</td>
						<td>${prod.productName }</td>
						<td>${prod.productDescription }</td>
						<td>${prod.productCost }</td>
						<td>
							<a href="adminDeleteProduct?id=${prod.id }">DELETE</a>
							<span>|</span>
							<a href="adminEditProduct?id=${prod.id }">EDIT</a>
						</td>
					</tr> 
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	</br>
	<c:if test="${msg != null }">
		<p><strong>${msg }</strong></p>
	</c:if>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>