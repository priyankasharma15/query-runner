<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="psharma.qr.bean.QueryResult"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QueryResult</title>
<link href="NewCSS.css" rel="stylesheet" type="text/css">
</head>
<%
	QueryResult qr;
	qr = (QueryResult) session.getAttribute("QueryResult");
%>
<body>
<body>
	<%@ include file="Header.jsp"%>

	<TABLE BORDER="2">

		<TR>
			<%
				for (String str : qr.getColumnName()) {
			%>

			<TD><%=str%></TD>
			<%
				}
			%>

		</TR>



		<%
			for (List<String> valueList : qr.getRows()) {
		%>
		<TR>
			<%
				for (String str : valueList) {
			%>

			<TD><%=str%></TD>

			<%
				}
			%>
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