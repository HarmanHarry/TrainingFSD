
<header>
	<h1 align="center">Corona Prevention Kit Portal</h1>
		<%String sname=(String)session.getAttribute("user"); %>
		<%if(sname!=null) {%>
		<hr/>
		<div>
			<strong><span >Welcome, <%=sname %></span></strong> | 
			<strong><span ><a href="index.jsp">Logout</a></span></strong>
			</div>
			<%} %>
		
	
</header>
<hr/>