package bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookstore.dao.UserDao;
import bookstore.dbutil.DBUtil;
import bookstore.entity.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String useruname=request.getParameter("uname");
		String userpassword=request.getParameter("pass");
		
		UserDao dao= new UserDao(DBUtil.getConnection());
		
		User u=dao.getUserByUnameAndPassword(useruname, userpassword);
		
		if(u==null) {
			
			out.println("Invalid Details!!.. Try again");
			
			HttpSession s=request.getSession();
			
			response.sendRedirect("login.jsp");		
			
		}
		else {
			HttpSession s=request.getSession();
			s.setAttribute("currentUser", u);
			response.sendRedirect("welcome.jsp");
			
		}
		
	}

}
