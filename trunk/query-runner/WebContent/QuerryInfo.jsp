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
<script>
	function myFunction(link,id,numParam,param) {
		var url;
   if (numParam>=1){
		
				var parameter=prompt("Please enter the parameter");
			url = link + id + "&params=" + parameter;
			
   }
   
   else {
	   url = link + id;
		
   }
   window.location.assign(url);
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quries</title>
<link href="NewCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="Header.jsp"%>
	<p>Please select the Query</p> <br>

	<TABLE id="box-table-a">
		
		<TR>
			<TH>ID</TH>
			<TH>QUERY_NAME</TH>
			<TH>QUERY_DESCRIPTION</TH>
			<TH>SQL_QUERY</TH>
			<TH>NUM_PARAMS</TH>
			<TH>PARAMS</TH>
			<TH>STATUS</TH>
			<TH>EDIT</TH>
		</TR>

		<%
			QueryInfoManager ob = new QueryInfoManager();
			List<QueryInfo> list = ob.getQueryInfo();
			for (QueryInfo qi : list) {
		%>

		<TR>
			<TD><%=qi.getId()%></TD>

			<TD><a
				onclick="myFunction('SelectQuery?id=',<%=qi.getId()%>,<%=qi.getNumParam()%>,'<%=qi.getParams()%>')"
				href="#"><%=qi.getQueryName()%> </a></TD>
			<TD><a
				onclick="myFunction('SelectQuery?id=',<%=qi.getId()%>,<%=qi.getNumParam()%>,'<%=qi.getParams()%>')"
				href="#"><%=qi.getQueryDescription()%> </a></TD>
			<TD><a
				onclick="myFunction('SelectQuery?id=',<%=qi.getId()%>,<%=qi.getNumParam()%>,'<%=qi.getParams()%>')"
				href="#"><%=qi.getSqlQuery()%> </a></TD>
			<TD><a
				onclick="myFunction('SelectQuery?id=',<%=qi.getId()%>,<%=qi.getNumParam()%>,'<%=qi.getParams()%>')"
				href="#"><%=qi.getNumParam()%> </a></TD>
			<TD><a
				onclick="myFunction('SelectQuery?id=',<%=qi.getId()%>,<%=qi.getNumParam()%>,'<%=qi.getParams()%>')"
				href="#"><%=qi.getParams()%> </a></TD>
			<TD><a
				onclick="myFunction('SelectQuery?id=',<%=qi.getId()%>,<%=qi.getNumParam()%>,'<%=qi.getParams()%>')"
				href="#"><%=qi.getStatus()%> </a></TD>
            <TD> <a href="EditQuery.jsp?id=<%=qi.getId()%>">Edit</a></TD>
            
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