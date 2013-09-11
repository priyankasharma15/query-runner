<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="psharma.qr.bean.ConnectionInfo"%>
<%@ page import="psharma.qr.service.ConInfoManager"%>
<%@ page import="java.util.List"%>
<%	/**
-----------------------------------------------------------------------------
query-runner is available for use under the following license, commonly known
as the 3-clause (or "modified") BSD license:
-----------------------------------------------------------------------------
Copyright (c) 2013, Priyanka Sharma (sharmapriyanka334@gmail.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:
1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. The name of the author may not be used to endorse or promote products
   derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR 'AS IS' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
-----------------------------------------------------------------------------
**/
%>
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