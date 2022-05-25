package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {
	private Connection connection;
	private static final String SQL_SELECT_ALL = "SELECT * FROM (SELECT product_id, category_id, p.name p_name, price, c.name c_name, description FROM categories c JOIN products p ON c.id = p.category_id) a";
	private static final String SQL_SELECT_SEARCH_WHERE_KEYWORD = "SELECT * FROM \r\n"
			+ " (SELECT product_id, category_id, p.name p_name, price, c.name c_name, description FROM categories c JOIN products p ON c.id = p.category_id) a\r\n"
			+ "WHERE c_name LIKE ? OR p_name LIKE ?";
	private static final String SQL_SELECT_SEARCH_WHERE_PRODUCT_ID = "SELECT * FROM \r\n"
			+ " (SELECT product_id, category_id, p.name p_name, price, c.name c_name, description FROM categories c JOIN products p ON c.id = p.category_id) a\r\n"
			+ "WHERE product_id = ?";
	private static final String SQL_INSERT_PRODUCT = "INSERT INTO products(product_id, category_id, name, price, description, created_at) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE_PRODUCT = "DELETE FROM products WHERE product_id = ?";
	private static final String SQL_UPDATE_PRODUCT = "UPDATE products SET product_id = ?, name = ?, price = ?, category_id = ?, description = ?, updated_at = ? WHERE product_id = ?";

	public ProductDao(Connection connection) {
		this.connection = connection;
	}

	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Product u = new Product(rs.getInt("product_id"), rs.getInt("category_id"), rs.getString("c_name"), rs.getString("p_name"), rs.getInt("price"),
						rs.getString("description"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public Product findById(int product_id) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_SEARCH_WHERE_PRODUCT_ID)) {
			stmt.setInt(1, product_id);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return new Product(rs.getInt("product_id"), rs.getInt("category_id"), rs.getString("c_name"), rs.getString("p_name"), rs.getInt("price"),
						rs.getString("description"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}





	public List<Product> findByKeyword(String keyword) {
		List<Product> list = new ArrayList<Product>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_SEARCH_WHERE_KEYWORD)) {
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Product u = new Product(rs.getInt("product_id"), rs.getInt("category_id"), rs.getString("c_name"), rs.getString("p_name"), rs.getInt("price"),
						rs.getString("description"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//            throw new RuntimeException(e);
		}
		return list;
	}

	public void update(Integer product_id, Product product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_PRODUCT)) {
			
			stmt.setInt(1, product.getProduct_id());
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getPrice());
			stmt.setInt(4, product.getCategory_id());
			stmt.setString(5, product.getDescription());
			stmt.setTimestamp(6, product.getUpdate_at());
			stmt.setInt(7, product_id);
			
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			//    		throw new RuntimeException(e);
		}
	}
	
	public void delete(Integer product_id) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_PRODUCT)) {
			stmt.setInt(1, product_id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			//    		throw new RuntimeException(e);
		}
	}

	public void register(Product product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_PRODUCT)) {
			stmt.setInt(1, product.getProduct_id());
			stmt.setInt(2, product.getCategory_id());
			stmt.setString(3, product.getName());
			stmt.setInt(4, product.getPrice());
			stmt.setString(5, product.getDescription());
			stmt.setTimestamp(6, product.getCreate_at());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			//    		throw new RuntimeException(e);
		}
	}
}
