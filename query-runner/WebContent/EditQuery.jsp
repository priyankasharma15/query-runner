<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="psharma.qr.bean.QueryInfo"%>
<%@ page import="psharma.qr.service.QueryInfoManager"%>
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
<title>Edit Query</title>
<link href="NewCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
<% String idValue = request.getParameter("id");

			int id = Integer.parseInt(idValue);
			QueryInfoManager ob = new QueryInfoManager();
			QueryInfo qi = new QueryInfo();
			qi = ob.getQueryInfo(id);%>
			<%@ include file="Header.jsp"%>

	<form action="/QAA/EditQuery">

		<p>Please add query below</p>
		<TABLE BORDER="0" cellspacing="4" cellpadding="4">

			<TR>
				<TD align="right">Id</TD>
				<TD align="right"><input value="<%=qi.getId()%>" type="text" name="id"maxlength="4" /></TD>
			</TR>
			<TR>
				<TD align="right">Query Name</TD>
				<TD><input value="<%=qi.getQueryName()%>" type="text" name="queryName" maxlength="100"/></TD>
			</TR>
			<TR>
				<TD align="right">Query Description</TD>
				<TD><input value="<%=qi.getQueryDescription()%>" type="text" name="queryDescription" maxlength="1000"/></TD>
			</TR>
			<TR>
				<TD align="right">Sql Query</TD>
				<TD align="right"><textarea rows="4" cols="40" name="sqlQuery" id='sqlQuery'> <%=qi.getSqlQuery()%> </textarea></TD>
			</TR>
			<TR>
				<TD align="right">NumParam</TD>
				<TD align="right"><input value="<%=qi.getNumParam()%>" type="text" name="numParam" /></TD>
			</TR>
			<TR>
				<TD>Params</TD>
				<TD><input value="<%=qi.getParams()%>" type="text" name="params" maxlength="200"/></TD>
			</TR>
			<TR>
				<TD align="right">Status</TD>
				<TD align="right"><input value="<%=qi.getStatus()%>" type="text" name="status" maxlength="1"/></TD>
			</TR>
			<TR>
				<TD align="right"><input type="submit" name="submit" /></TD>
			</TR>
		</TABLE>
	</form>
	<%@ include file="Footer.jsp"%>

</body>
</html>