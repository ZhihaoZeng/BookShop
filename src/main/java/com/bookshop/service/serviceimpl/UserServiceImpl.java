package com.bookshop.service.serviceimpl;

import com.bookshop.dao.UserDao;
import com.bookshop.entity.User;
import com.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 2:02
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    UserDao userDao;

    /*find list of users by query of username
    * 通过用户名来查找用户*/
    public List<User> getUserByUserName(String userName){
        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);
        List<User> users = userDao.searchUsers(map);
        return users;
    }

    /*check if user with a certain name exists
    * 查找是否存在特定用户名的用户*/
    public boolean checkUserExistedByUserName(String userName){
        List<User> users = getUserByUserName(userName);
        if(users!=null && users.size()>0)return true;
        return false;
    }

    /*insert user
    * 插入用户*/
    public  User insertUser(User user){
        userDao.insertUser(user);
        /*the generated key has been assigned to the property "userId" of object "user" now
        * 此时数据库生成的主键id返回并且更新到user对象中*/
        return user;
    }

    /*delete an user (close an account)
    * 删除用户（注销账号）*/
    public boolean deleteUser(User user){
        if(checkUserExistedByUserName(user.getUserName())){
            userDao.deleteUser(user);
            return true;
        }else{
            return false;
        }
    }

    /*user login
    * 用户登录*/
    public User login(User user){
        if(user!=null){
            Map<String,String> map = new HashMap<>();
            map.put("user_password",user.getUserPassword());
            map.put("user_name",user.getUserName());
            List<User> loginUser = userDao.searchUsers(map);
            if(loginUser!=null||loginUser.size()==1){
                return user;
            }
        }
        return null;
    }

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }
}
