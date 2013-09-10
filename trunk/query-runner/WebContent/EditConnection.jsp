<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="psharma.qr.bean.ConnectionInfo"%>
<%@ page import="psharma.qr.service.ConInfoManager"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Connection</title>
<link href="NewCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="Header.jsp"%>

	
        <% String idValue = request.getParameter("id");
		int id = Integer.parseInt(idValue);
		ConInfoManager ob = new ConInfoManager();
		ConnectionInfo ci = new ConnectionInfo();
		ci = ob.getConnectionInfo(id);%>
		<form action="/QAA/EditConnection">
		<p>Please edit connection below</p>
		<TABLE BORDER="0" cellspacing="4" cellpadding="4">

		<TR>
		<TD align="right"> 
			Id </TD>  <TD><input value="<%= ci.getId() %>" type="text"  name="id" maxlength="4"/></TD> </TR>
		<TR>
		<TD align="right">
			Group Name</TD> <TD> <input value="<%= ci.getGroupName() %>" type="text"  name="groupName" maxlength="100"/></TD> </TR>
		<TR>
		<TD align="right">
			Connection Name</TD>  <TD> <input value="<%= ci.getConnectionName() %>" type="text"  name="connectionName" maxlength="100"/>
		</TD> </TR>
		<TR>
		<TD align="right">
			Connection Description</TD> <TD><input value="<%= ci.getConnectionDescription() %>" type="text" 
				name="connectionDescription" maxlength="100"/>
		</TD> </TR>
		<TR>
		<TD align="right">
			Url</TD> <TD>
			<textarea  rows="4" cols="40" name="url" id='url'> <%= ci.getUrl() %></textarea>
		</TD> </TR>
		<TR>
		<TD align="right">
			Username </TD> <TD><input value="<%= ci.getUsername() %>" type="text"  name="username" maxlength="50" />
		</TD> </TR>
		<TR>
		<TD align="right">
			Password </TD> <TD><input value="<%= ci.getPassword() %>"  type="text"  name="password" maxlength="50"/>
		</TD> </TR>
		<TR>
		<TD align="right">
			Status </TD> <TD><input value="<%= ci.getStatus() %>" maxlength="1" type="text" name="status" />
		</TD> </TR>
		<TR>
		<TD align="right"><input type="submit" name="submit" /></TD> </TR>
		</TABLE>
	</form>
	<%@ include file="Footer.jsp"%>

</body>
</html>