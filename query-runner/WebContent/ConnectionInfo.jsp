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