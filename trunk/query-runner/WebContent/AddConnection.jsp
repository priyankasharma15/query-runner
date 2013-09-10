<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	errorPage="errorpage.jsp" isErrorPage="true" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Connection</title>
<link href="NewCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="Header.jsp"%>

	<form action="AddConnection">
		<p>Please add connection below</p>
			<TABLE BORDER="0" cellspacing="4" cellpadding="4">

		<TR>
		
		<TD align="right">
			Group Name</TD> <TD> <input type="text" name="groupName" maxlength="50"/></TD> </TR>
		<TR>
		<TD align="right" >
			Connection Name</TD> <TD> <input type="text" name="connectionName" maxlength="100"/>
		</TD> </TR>
		<TR>
		<TD align="right">
			Connection Description</TD> <TD><input type="text"
				name="connectionDescription" maxlength="100" />
		</TD> </TR>
		<TR>
		<TD align="right" >
			Url</TD> <TD>
			<textarea rows="4" cols="40" name="url"></textarea>
		</TD> </TR>
		<TR>
		<TD align="right" >
			Username </TD> <TD><input type="text" name="username" maxlength="50"/>
		</TD> </TR>
		<TR>
		<TD align="right" >
			Password </TD> <TD><input type="text" name="password" maxlength="50"/>
		</TD> </TR>
		<TR>
		<TD align="right" >
			Status </TD> <TD><input type="text" name="status" maxlength="1" />
		</TD> </TR>
		<TR>
		<TD align="right" ><input type="submit" value="add" /></TD> </TR>
		</TABLE>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>