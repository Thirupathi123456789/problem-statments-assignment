package bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.dao.UserDao;
import bookstore.dbutil.DBUtil;

/**
 * Servlet implementation class SetPasswordServlet
 */
@WebServlet("/SetPassword")
public class SetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String password = request.getParameter("pass");
		String confirmpassword = request.getParameter("cpass");

		UserDao dao = new UserDao(DBUtil.getConnection());
		int u;
		try {
			u = dao.setPassword(password);
			if (!password.equals(confirmpassword)) {
				RequestDispatcher rd = request.getRequestDispatcher("setpassword.jsp");
				rd.include(request, response);
				out.println("<center>Password Not Match!!</center>");
			} else
			{
				response.sendRedirect("passwordset.jsp");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
