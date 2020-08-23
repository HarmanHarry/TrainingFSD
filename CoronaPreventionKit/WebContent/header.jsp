
<header>
	<h1>Corona Prevention Kit</h1>
		<%String sname=(String)session.getAttribute("user"); %>
		<%if(sname!=null) {%>
		<hr/>
		<nav>
			<strong><label>Welcome, <%=sname %></label></strong> | 
			<strong><a href="index.jsp">Logout</a></strong>
			<%} %>
		
	
</header>