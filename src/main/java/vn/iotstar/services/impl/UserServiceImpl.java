package iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.entity.Users;
import vn.iotstar.services.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserDao userDao = new UserDaoImpl();
    @Override
    public Users findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void insert(Users user) {
        userDao.insert(user);
    }

    @Override
    public void update(Users user) {
        userDao.update(user);
    }

    @Override
    public void delete(String username) throws Exception {
        userDao.delete(username);
    }

    @Override
    public List<Users> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<Users> findAll(int page, int pagesize) {
        return userDao.findAll(page, pagesize);
    }

    @Override
    public int count() {
        return userDao.count() ;
    }

    @Override
    public Users Login(String username, String password) {
        Users user = this.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
