package com.bookshop.service;

import com.bookshop.entity.User;

import java.util.List;
/**
 * @InterfaceName: UserService
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 2:00
 */
public interface UserService {
    public boolean checkUserExistedByUserName(String userName);
    public User insertUser(User user);
    public boolean deleteUser(User user);
    public User login(User user);
}
