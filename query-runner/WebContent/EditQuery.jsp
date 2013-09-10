<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="psharma.qr.bean.QueryInfo"%>
<%@ page import="psharma.qr.service.QueryInfoManager"%>
<%@ page import="java.util.List"%>
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