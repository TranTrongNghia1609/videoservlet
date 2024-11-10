package iotstar.services;

import vn.iotstar.entity.Users;

import java.util.List;

public interface IUserService {
    Users findByUsername(String username);
    void insert(Users user);
    void update(Users user);
    void delete(String username) throws Exception;
    List<Users> findAll();
    List<Users> findAll(int page, int pagesize);
    int count();
    Users Login(String username, String password);
}
