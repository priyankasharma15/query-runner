package psharma.qr.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import psharma.qr.bean.QueryInfo;
import psharma.qr.service.QueryInfoManager;


/**
 * Servlet implementation class EditQuery
 */
@WebServlet("/EditQuery")
public class EditQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryInfo qi = new QueryInfo();
		int id = Integer.parseInt(request.getParameter("id"));
		String queryName = request.getParameter("queryName");
		String queryDescription = request.getParameter("queryDescription");
		String sqlQuery = request.getParameter("sqlQuery");
		int numParam = Integer.parseInt(request.getParameter("numParam"));
		String params = request.getParameter("params");
		String status = request.getParameter("status");
		qi.setId(id);
		qi.setQueryName(queryName);
		qi.setQueryDescription(queryDescription);
		qi.setSqlQuery(sqlQuery);
		qi.setNumParam(numParam);
		qi.setParams(params);
		qi.setStatus(status);

		QueryInfoManager qim = new QueryInfoManager();
		qim.saveQueryInfo(qi);
		response.sendRedirect("ComfirmQuery.jsp");
	}

}
