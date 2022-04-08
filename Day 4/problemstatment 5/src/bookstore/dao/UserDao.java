package bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bookstore.entity.User;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}
//	method to insert in database
	public boolean saveUser(User user) {
		boolean f=false;

		try {
			String query="insert into users(first_name,address,email,user_name,password)values (?,?,?,?,?)";
			PreparedStatement pstmt	=this.con.prepareStatement(query);
			pstmt.setString(1,user.getFirst_name());
			pstmt.setString(2,user.getAddress());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4,user.getUser_name());
			pstmt.setString(5,user.getPassword());
			
			pstmt.executeUpdate();
			f=true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}
	public User getUserByUnameAndPassword(String user_name, String password) {
		User user=null;
		try {
			String query="select * from users where user_name=? and password=?";
			
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, user_name);
			psmt.setString(2, password);
			
			ResultSet set=psmt.executeQuery();
			
			if(set.next()) {
				user=new User();

				user.setFirst_name("fname");
				user.setAddress("address");
				user.setEmail(set.getString("email"));
				user.setUser_name("uname");
				user.setPassword(set.getString("password"));
//				user.setRegistration_date(set.getTimestamp("rdate"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return user;
	}
	public User resetpassword(String uemail,String uname) {
		User user=null;
		try {
			String query="select * from users where user_name=? and email=?";
			
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, uname);
			psmt.setString(2, uemail);
			
			ResultSet set=psmt.executeQuery();
			
			if(set.next()) {
				user=new User();

				user.setFirst_name("fname");
				user.setAddress("address");
				user.setEmail(set.getString("email"));
				user.setUser_name("uname");
				user.setPassword(set.getString("password"));
//				user.setRegistration_date(set.getTimestamp("rdate"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return user;
	}
public int setPassword(String pass) throws SQLException {
	
		String query="update users set password=? where user_name=?";
		User user=new User();
		PreparedStatement psmt=con.prepareStatement(query);
		psmt.setString(1, pass);
		psmt.setString(2,(user.getUser_name()));
		return psmt.executeUpdate();
	}
}
