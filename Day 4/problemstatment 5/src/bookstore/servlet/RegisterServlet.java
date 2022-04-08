package bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.dao.UserDao;
import bookstore.dbutil.DBUtil;
import bookstore.entity.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name = request.getParameter("fname");
		String address = request.getParameter("address");
		String email = request.getParameter("uemail");
		String user_name = request.getParameter("name");
		String password = request.getParameter("upass");
		PrintWriter out=response.getWriter();
		User user=new User(first_name, address, email, user_name, password);
		UserDao dao=new UserDao(DBUtil.getConnection());
		if(dao.saveUser(user)) {
			out.println("Register");
			response.sendRedirect("login.jsp");
			
		}
		else {
			out.println("Registratin failed!!");
		}
	}

}

