package com.bookshop.service;

import com.bookshop.entity.User;
import com.bookshop.exception.UserNameIsUsedException;
import com.bookshop.util.Page;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: UserService
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 2:00
 */
public interface UserService {
    boolean checkUserExistedByUserName(String userName);
    User login(User user);

    User getUser(Long userId);
    Page<User> getAllUsersPage(Integer startPage);
    List<User> getAllUsers();

    Page<User> searchUsersPage(Map<String,Object> queryMap);

    User insertUser(User user) throws Exception;

    Boolean updateUser(User user);
    Integer updateUsers(List<User> users);

    Boolean deleteUserBytId(Long userId);
    Boolean deleteUser(User user);
    Integer deleteUsers(List<User> users);

    Integer count(Map map);

}
