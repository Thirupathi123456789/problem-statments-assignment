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
import bookstore.entity.Orders;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String Cust_Name=request.getParameter("cname");
		String Address=request.getParameter("address");
		int no=Integer.parseInt(request.getParameter("no"));
		int qau=Integer.parseInt(request.getParameter("qau"));
		Orders order=new Orders(Address, no, Cust_Name);
		UserDao dao= new UserDao(DBUtil.getConnection());
		dao.order(order);
	}

}
