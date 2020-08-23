<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Not Found</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
	<div>
		<h3>Requested Resource Not Available</h3>
	</div>
</br>
	<c:if test="${errMsgNotAuth != null }">
		<p><strong>${errMsgNotAuth }</strong></p>
	</c:if>
	
<hr/>
	<jsp:include page="footer.jsp"/>
</body>
</html>