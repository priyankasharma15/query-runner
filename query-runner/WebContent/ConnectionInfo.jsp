<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="psharma.qr.bean.ConnectionInfo"%>
<%@ page import="psharma.qr.service.ConInfoManager"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connection</title>
<link href="NewCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="Header.jsp"%>
	<p>Please select the Connection</p> <br>
	<TABLE id="box-table-a">

		<TR>
			<TH>ID</TH>
			<TH>GROUP_NAME</TH>
			<TH>CONNECTION_NAME</TH>
			<TH>CONNECTION_DESCRIPTION</TH>
			<TH>URL</TH>
			<TH>USERNAME</TH>
			<TH>PASSWORD</TH>
			<TH>STATUS</TH>
			<TH>EDIT</TH>
		</TR>

		<%
			ConInfoManager cm = new ConInfoManager();
			List<ConnectionInfo> list = cm.getConInfo();
			for (ConnectionInfo ci : list) {
		%>

		<TR>
			<TD><a href="SelectConnection?id=<%=ci.getId()%>"><%=ci.getId()%></a></TD>
			<TD><a href="SelectConnection?id=<%=ci.getId()%>"><%=ci.getGroupName()%></a></TD>
			<TD><a href="SelectConnection?id=<%=ci.getId()%>"> <%=ci.getConnectionName()%>
			</a></TD>
			<TD><a href="SelectConnection?id=<%=ci.getId()%>"><%=ci.getConnectionDescription()%></a></TD>
			<TD><a href="SelectConnection?id=<%=ci.getId()%>"><%=ci.getUrl()%></a></TD>
			<TD><a href="SelectConnection?id=<%=ci.getId()%>"><%=ci.getUsername()%></a></TD>
			<TD><a href="SelectConnection?id=<%=ci.getId()%>"><%=ci.getPassword()%></a></TD>
			<TD><a href="SelectConnection?id=<%=ci.getId()%>"><%=ci.getStatus()%></a></TD>
			<TD><a href="EditConnection.jsp?id=<%=ci.getId()%>">Edit</a></TD>

		</TR>

		<%
			}
		%>
	</TABLE>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="Footer.jsp"%>

</body>
</html>