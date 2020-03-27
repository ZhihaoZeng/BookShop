package com.bookshop.dao;

import com.bookshop.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: UserDao
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:53
 */
public interface UserDao {
    public User getUser(Long userId);
    public List<User> getAllUsersPage(Map map);
    public List<User> getAllUsers();

    public List<User> searchUsers(Map map);

    public void insertUser(User user);
    public void insertUsers(List<User> users);//插入，用实体作为参数

    public void updateUser(User user);
    public void updateUsers(List<User> users);

    public void deleteUser(User userId);
    public void deleteUsers(List<User> userIds);

}
