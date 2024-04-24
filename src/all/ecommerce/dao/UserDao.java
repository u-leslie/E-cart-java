package all.ecommerce.dao;

import java.sql.*;
import all.ecommerce.model.*;
public class UserDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
        try {
            query = "select * from users where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }

    public boolean registerUser(User user) {
        boolean result = false;
        try {
            // Insert user details into the database
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, user.getName());
                pst.setString(2, user.getEmail());
                pst.setString(3, user.getPassword());

                int rowsAffected = pst.executeUpdate();
                result = (rowsAffected > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }
}
