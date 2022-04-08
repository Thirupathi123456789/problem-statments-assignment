package bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.dao.UserDao;
import bookstore.dbutil.DBUtil;
import bookstore.entity.User;

@WebServlet("/ResetServlet")
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email = request.getParameter("uemail");
		String user_name = request.getParameter("uname");
		UserDao dao=new UserDao(DBUtil.getConnection());
		User user=dao.resetpassword(email, user_name);
		if(user==null)
		{
			out.println("Invalid Details.....!!!!");
		}
		else
		{
			response.sendRedirect("setpassword.jsp");
		}
	}

}
