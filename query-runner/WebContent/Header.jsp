

<div id="banner" align="center">
	<h1>QUALITY RUNNER</h1>
</div>

<% if (request.getSession()==null){
	response.sendRedirect("index.jsp");}%>
	

<hr>

<a href="ConnectionInfo.jsp">Connection</a>
|
<a href="AddConnection.jsp">Add Connections</a>
|
<a href="QuerryInfo.jsp">Queries</a>
|
<a href="AddQuery.jsp">Add Queries</a>
|
<a href="LogOut.jsp"> Logout</a>
<hr>


