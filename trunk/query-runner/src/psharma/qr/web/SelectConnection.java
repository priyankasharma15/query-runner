package psharma.qr.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import psharma.qr.bean.ConnectionInfo;
import psharma.qr.service.ConInfoManager;


@WebServlet("/SelectConnection")
public class SelectConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idValue = request.getParameter("id");
		int id = Integer.parseInt(idValue);
		ConInfoManager ob = new ConInfoManager();
		ConnectionInfo ci = new ConnectionInfo();
		ci = ob.getConnectionInfo(id);
		System.out.println(ci);
		HttpSession hp = request.getSession(true);
		hp.setAttribute("ConnectionInfo", ci);
		response.sendRedirect("QuerryInfo.jsp");

	}

}
