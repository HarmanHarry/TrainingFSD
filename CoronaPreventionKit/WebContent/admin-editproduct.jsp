<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Edit Product(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<h3><u>Edit Product</u></h3>
	</br>
	<form action="adminSaveProduct" method="post">
		<div>
			<label>Product Id</label>
			<input type="number" name="id" value="${prod.id}" required readonly/>
		</div>	
		</br>
		<div>
			<label>Product Name</label>
			<input type="text" name="pname" value="${prod.productName}" required />
		</div>	
		</br>
		<div>
			<label>Product Description</label>
			<input type="text" name="pdesc" value="${prod.productDescription}"  required />
		</div>	
		</br>
		<div>
			<label>Product Cost</label>
			<input type="decimal" name="pcost" value="${prod.productCost}" required />
		</div>	
		</br>	
		<button>SAVE PRODUCT</button>		
	</form>
	
	</br>
	<c:if test="${errMsg != null }">
		<p><strong>${errMsg }</strong></p>
	</c:if>
</br>

	<jsp:include page="footer.jsp"/>
</body>
</html>