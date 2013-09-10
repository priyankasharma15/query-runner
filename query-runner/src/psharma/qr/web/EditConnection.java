package psharma.qr.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import psharma.qr.bean.ConnectionInfo;
import psharma.qr.service.ConInfoManager;


@WebServlet("/EditConnection")
public class EditConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionInfo ci = new ConnectionInfo();
		int id = Integer.parseInt(request.getParameter("id"));
		String groupName = request.getParameter("groupName");
		String connectionName = request.getParameter("connectionName");
		String connectionDescription = request.getParameter("connectionDescription");
		String url = request.getParameter("url");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String status = request.getParameter("status");
		ci.setId(id);
		ci.setGroupName(groupName);
		ci.setConnectionName(connectionName);
		ci.setConnectionDescription(connectionDescription);
		ci.setUrl(url);
		ci.setUsername(username);
		ci.setPassword(password);
		ci.setStatus(status);
		ConInfoManager cim = new ConInfoManager();
		cim.saveConnectionInfo(ci);
		System.out.println(ci);
		response.sendRedirect("ConfirmConnection.jsp");

	}

}
