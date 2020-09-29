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
	<nav class="navbar navbar-expand-md bg-info navbar-dark">
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
 <div class="collapse navbar-collapse" id="collapsibleNavbar">
 	<ul class="navbar-nav">
 		<li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath }/user/home">DASHBOARD</a>
	      </li> 
 		<li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath }/user/show-cart">KIT DETAILS</a>
	      </li> 
		<li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath }/user/show-list">AVALIABLE PRODUCTS</a>
	     </li>
	     <li class="nav-item">
	      	  <a class="nav-link" href="${pageContext.request.contextPath }/logout">LOGOUT</a>
	      	</li> 	     
	 </ul> 
	 </div>
	 </nav>
	 <marquee><h5>Available Products</h5></marquee>
</br>
<form action="${pageContext.request.contextPath }/user/add-to-cart" method="post">
	<c:choose>
		<c:when test="${allProducts == null || allProducts.isEmpty() }">
			<p class="well">No Products Available</p>
		</c:when>
		<c:otherwise>
		<p><u>Select the Required Products and Add to Cart</u></p>
			<table class="table table-striped table-hover">
				<tr>
					<th>Product Name</th>
					<th>Description</th>
					<th>Cost</th>
					<th>Quantity</th>
					<th>Select Product</th>
				</tr>
				<c:forEach items="${allProducts }" var="product">
					<tr>
						<td>${product.productName }</td>
						<td>${product.productDescription }</td>
						<td>${product.cost }</td>
						<td><input type="number" name="quantity" min="0" value="0"/></td>
						<td><input class="form-check-label" type="checkbox" name="prods" value="${product.id }"/></td>
					</tr> 
				</c:forEach>
			</table>
				</br>									
					<button class="btn-info">ADD TO CART</button>
								
		</c:otherwise>
	</c:choose>
				</form>
			
	
	<jsp:include page="footer.jsp" />
</html>