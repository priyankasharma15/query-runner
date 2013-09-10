<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="psharma.qr.bean.QueryInfo"%>
<%@ page import="psharma.qr.service.QueryInfoManager"%>
<%@ page import="java.util.List"%>
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
<title>Qeries</title>
<link href="NewCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="Header.jsp"%>
	<p>Please select the Query</p>

	<TABLE id="box-table-a">
		
		<TR>
			<TD>ID</TD>
			<TD>QUERY_NAME</TD>
			<TD>QUERY_DESCRIPTION</TD>
			<TD>SQL_QUERY</TD>
			<TD>NUM_PARAMS</TD>
			<TD>PARAMS</TD>
			<TD>STATUS</TD>
			<TD>EDIT</TD>
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