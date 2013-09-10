<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login the QCA Application</title>

<link href="NewCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>QUERY RUNNER</h1>

	<form action="LogIn">
		<hr>
		<%=new java.util.Date()%>
		<hr>
		<%
			String msgCode = request.getParameter("msgCode");

			if ("1".equals(msgCode)) {
		%>
		<%="OOps! username and password combination did not match."%>
		<%
			}
		%>

		<p>Please log in</p>
		<TABLE BORDER="0" cellspacing="4" cellpadding="4">

			<TR>
				<TD>Enter Username</TD>
				<TD><input type="text" name="username" maxlength="100"/></TD>
			</TR>
			<TR>
				<TD>Enter Password</TD>
				<TD><input type="password" name="password" maxlength="100"/></TD>
			</TR>
			<TR>
				<TD colspan="2" align="center"><input type="submit"
					value="Login" /></TD>
			</TR>
		</TABLE>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>