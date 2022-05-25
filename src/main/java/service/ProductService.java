package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class ProductService {

	public List<Product> find() {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao ProductDao = new ProductDao(conn);
			return ProductDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public Product findById(Integer product_id) {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao ProductDao = new ProductDao(conn);
			return ProductDao.findById(product_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Product> findByKeyword(String keyword) {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao ProductDao = new ProductDao(conn);
			return ProductDao.findByKeyword(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}


	public void update(Integer product_id, Product product) {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao ProductDao = new ProductDao(conn);
			ProductDao.update(product_id, product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Integer product_id) {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao ProductDao = new ProductDao(conn);
			ProductDao.delete(product_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void register(Product product) {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao ProductDao = new ProductDao(conn);
			ProductDao.register(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}