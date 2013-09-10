package psharma.qr.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import psharma.qr.bean.UserInfo;
import psharma.qr.service.UserLogInManager;


/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserInfo ob = new UserInfo();
		ob.setUsername(username);
		ob.setPassword(password);
		System.out.println(ob);
		UserLogInManager obj = new UserLogInManager();
		boolean result = obj.validatePassword(ob);
		
		

		if (result == true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", ob.getUsername());
			response.sendRedirect("ConnectionInfo.jsp");
		} else {

			response.sendRedirect("index.jsp?msgCode=1");
		}

	}

}
