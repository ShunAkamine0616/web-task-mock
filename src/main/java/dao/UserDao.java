package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao {
	private Connection connection;
	private static final String SQL_SELECT_ALL = "SELECT * FROM users ORDER BY login_id";
	private static final String SQL_INSERT_USER = "INSERT INTO products(product_name, price) VALUES(?, ?)";
	private static final String SQL_SELECT_WHERE_USER_ID_AND_PASS = "SELECT * FROM users WHERE login_id = ? and password = ?";

	
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<User> findAll() {
		  List<User> list = new ArrayList<User>();

	        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                User u = new User(rs.getString("loginId"), rs.getString("password"));
	                list.add(u);
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return list;
	}
	
//	public User findById(int productId) {
//    	try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_PRODUCT_ID)) {
//    		stmt.setInt(1, productId);
//    		ResultSet rs = stmt.executeQuery();
//    		
//    		if(rs.next()) {
//    			return new User(rs.getString("loginId"), rs.getString("password"));
//    		}
//    	} catch (SQLException e) {
//    		throw new RuntimeException(e);
//    	}
//    	
//        return null;
//    }
	
	
	
	public User findByUserIdAndPass(String UserId, String pass) {
//		List<User> list = new ArrayList<User>();
		User u = new User();
        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_USER_ID_AND_PASS)) {
        	stmt.setString(1, UserId);
        	stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                u = new User(rs.getString("login_id"), rs.getString("password"), rs.getString("name"), rs.getInt("role"));
//                list.add(u);
                return u;
            }
        } catch (SQLException e) {
        	e.printStackTrace();
//            throw new RuntimeException(e);
        }
        return null;
	}
	
	public void register(User product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_USER)) {
    		stmt.setString(1, product.getLoginId());
    		stmt.setString(2, product.getPassword());
    		
    		stmt.executeUpdate();
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
	}
}
