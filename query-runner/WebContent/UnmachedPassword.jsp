<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unmached Password</title>
<link href="NewCSS.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#E6E6FA">
	<%
		String username = (String) session.getAttribute("username");
		if (username == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<p>OOps! username and password combination did not matched</p>
	<a href="index.jsp"> Retry </a>
</body>
</html>