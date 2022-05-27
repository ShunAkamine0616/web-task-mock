package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Category;

public class CategoryDao {
	private Connection connection;
	private static final String SQL_SELECT_ALL = "SELECT * FROM categories";
	private static final String SQL_INSERT_USER = "INSERT INTO products(product_name, price) VALUES(?, ?)";
	private static final String SQL_SELECT_SEARCH_WHERE_KEYWORD = "SELECT * FROM \r\n"
			+ " (SELECT product_id, category_id, p.name p_name, price, c.name c_name, description FROM categories c JOIN products p ON c.id = p.category_id) a\r\n"
			+ "WHERE c_name LIKE '%?%' OR p_name LIKE ?";
	
	
	public CategoryDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<Category> findAll() {
		  List<Category> list = new ArrayList<Category>();

	        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Category u = new Category(rs.getInt("id"), rs.getString("name"));
	                list.add(u);
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return list;
	}
	
	public List<Category> findByKeyword(String keyword) {
		List<Category> list = new ArrayList<Category>();
        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_SEARCH_WHERE_KEYWORD)) {
        	stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Category u = new Category(rs.getInt("id"), rs.getString("name"));
                list.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
	}
//	public Category findById(int productId) {
//    	try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_PRODUCT_ID)) {
//    		stmt.setInt(1, productId);
//    		ResultSet rs = stmt.executeQuery();
//    		
//    		if(rs.next()) {
//    			return new Category(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
//    		}
//    	} catch (SQLException e) {
//    		throw new RuntimeException(e);
//    	}
//    	
//        return null;
//    }
//	
//	public List<Category> findByName(String name) {
//		List<Category> list = new ArrayList<Category>();
//        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_PRODUCT_NAME)) {
//        	stmt.setString(1, name);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                Category u = new Category(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
//                list.add(u);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//	}
//	

//	public void register(Category product) {
//		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_USER)) {
//    		stmt.setString(1, product.getCategory_name());
//    		stmt.setInt(2, product.getPrice());
//    		
//    		stmt.executeUpdate();
//    	} catch (SQLException e) {
//    		throw new RuntimeException(e);
//    	}
//	}
}
