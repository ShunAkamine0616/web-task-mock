package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.CategoryDao;
import entity.Category;
import util.DbUtil;

public class CategoryService {

//    public Category authentication(int id) {
//        try (Connection conn = DbUtil.getConnection()) {
//            CategoryDao CategoryDao = new CategoryDao(conn);
//            Category Category = CategoryDao.findById(id);
//
//            return Category;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

//    public List<Category> find() {
//        try (Connection conn = DbUtil.getConnection()) {
//            CategoryDao CategoryDao = new CategoryDao(conn);
//            return CategoryDao.findAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return Collections.emptyList();
//    }
    
	public List<Category> findByKeyword(String keyword) {
        try (Connection conn = DbUtil.getConnection()) {
            CategoryDao CategoryDao = new CategoryDao(conn);
            return CategoryDao.findByKeyword(keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

//    public List<Category> findByName(String name) {
//        try (Connection conn = DbUtil.getConnection()) {
//            CategoryDao CategoryDao = new CategoryDao(conn);
//            return CategoryDao.findByName(name);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return Collections.emptyList();
//    }
    
    
   
//    public void register(Category Category) {
//        try (Connection conn = DbUtil.getConnection()) {
//            CategoryDao CategoryDao = new CategoryDao(conn);
//            CategoryDao.register(Category);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
