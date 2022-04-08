package bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bookstore.entity.User;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}

//	method to insert in database
	public boolean saveUser(User user) {
		boolean f = false;

		try {
			String query = "insert into users(first_name,address,email,user_name,password)values (?,?,?,?,?)";
			PreparedStatement pstmt = this.con.prepareStatement(query);
			pstmt.setString(1, user.getFirst_name());
			pstmt.setString(2, user.getAddress());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUser_name());
			pstmt.setString(5, user.getPassword());

			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	public User getUserByUnameAndPassword(String user_name, String password) {
		User user = null;
		try {
			String query = "select * from users where user_name=? and password=?";

			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, user_name);
			psmt.setString(2, password);

			ResultSet set = psmt.executeQuery();

			if (set.next()) {
				user = new User();

				user.setFirst_name("fname");
				user.setAddress("address");
				user.setEmail(set.getString("email"));
				user.setUser_name("uname");
				user.setPassword(set.getString("password"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
