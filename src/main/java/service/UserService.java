package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.UserDao;
import entity.User;
import util.DbUtil;

public class UserService {

//    public User authentication(int id) {
//        try (Connection conn = DbUtil.getConnection()) {
//            UserDao UserDao = new UserDao(conn);
//            User User = UserDao.findById(id);
//
//            return User;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    public List<User> find() {
        try (Connection conn = DbUtil.getConnection()) {
            UserDao UserDao = new UserDao(conn);
            return UserDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
    
    

//    public List<User> findByName(String name) {
//        try (Connection conn = DbUtil.getConnection()) {
//            UserDao UserDao = new UserDao(conn);
//            return UserDao.findByName(name);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return Collections.emptyList();
//    }
    
    
    public User findByUserIdAndPass(String login_id, String password) {
        try (Connection conn = DbUtil.getConnection()) {
            UserDao UserDao = new UserDao(conn);
            return UserDao.findByUserIdAndPass(login_id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    
    public void register(User User) {
        try (Connection conn = DbUtil.getConnection()) {
            UserDao UserDao = new UserDao(conn);
            UserDao.register(User);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
