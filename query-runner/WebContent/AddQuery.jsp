<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	errorPage="errorpage.jsp" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Query</title>
<link href="NewCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="Header.jsp"%>

	<form action="AddQuery">

		<p>Please add query below</p>
		<TABLE BORDER="0" cellspacing="4" cellpadding="4">

			
			<TR>
				<TD align="right" >Query Name</TD>
				<TD><input type="text" name="queryName" maxlength="100"/></TD>
			</TR>
			<TR>
				<TD align="right" >Query Description</TD>
				<TD><input type="text" name="queryDescription" maxlength="1000"/></TD>
			</TR>
			<TR>
				<TD align="right" >Sql Query</TD>
				<TD><textarea rows="4" cols="40" name="sqlQuery" ></textarea></TD>
			</TR>
			<TR>
				<TD align="right" >NumParam</TD>
				<TD><input type="text" name="numParam" /></TD>
			</TR>
			<TR>
				<TD align="right" >Params</TD>
				<TD><input type="text" name="params" maxlength="200" /></TD>
			</TR>
			<TR>
				<TD align="right">Status</TD>
				<TD ><input type="text" name="status" maxlength="1" /></TD>
			</TR>
			<TR>
				<TD><input type="submit" value="add" /></TD>
			</TR>
		</TABLE>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>