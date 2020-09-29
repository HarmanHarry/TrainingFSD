<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Displays added products</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
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
	
	<br> 
<c:choose>  
        <c:when test="${KitDetails == null || KitDetails.isEmpty() }">  
            <p>No Products has been added to Cart</p>  
        </c:when>  
        <c:otherwise>  
        <p><u>Below Products are Added to Cart</u> </p> 
        <br/>
            <table class="table table-striped table-hover"> 
                <tr>  
                    <th>Product id#</th>  
                    <th>Product Name</th>  
                    <th>Product Quantity</th>         
                    <th>Product Amount</th>     
                    <th>Action</th>                             
                </tr>  
                <c:forEach items="${KitDetails}" var="kitItem">  
                    <tr>  
                        <td>${kitItem.productId }</td>  
                        <td>${kitItem.productName }</td>  
                        <td>${kitItem.quantity }</td>  
                        <td>${kitItem.amount}</td>                  
                        <td> <a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath }/user/delete?productId=${kitItem.productId}">Delete Product</a> </td> 
                    </tr>  
                </c:forEach>  
            </table>  
            
            <nav>
		   		<br/>          
		        <a class="btn btn-sm btn-info"href="${pageContext.request.contextPath }/user/checkout">CHECKOUT</a>               
   			 </nav>   
        </c:otherwise>  
    </c:choose> 
    
    
<jsp:include page="footer.jsp" />
</body>
</html>