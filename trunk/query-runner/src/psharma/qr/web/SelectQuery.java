package psharma.qr.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import psharma.qr.bean.ConnectionInfo;
import psharma.qr.bean.QueryInfo;
import psharma.qr.bean.QueryResult;
import psharma.qr.service.QueryInfoManager;
import psharma.qr.service.QueryManager;


@WebServlet("/SelectQuery")
public class SelectQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idValue = request.getParameter("id");

		int id = Integer.parseInt(idValue);
		QueryInfoManager ob = new QueryInfoManager();
		QueryInfo qi = new QueryInfo();
		qi = ob.getQueryInfo(id);
		System.out.println(qi);
		HttpSession hs = request.getSession(true);
		ConnectionInfo ci;
		ci = (ConnectionInfo) hs.getAttribute("ConnectionInfo");
		QueryManager qm = new QueryManager();
		QueryResult qr;
		String params = request.getParameter("params");
		qr = qm.getQuery(qi, ci, params);

		HttpSession hp = request.getSession(true);
		hp.setAttribute("QueryResult", qr);
		response.sendRedirect("Result.jsp");

	}

}
