package com.bookshop.service.serviceImpl;

import com.bookshop.dao.UserDao;
import com.bookshop.entity.User;
import com.bookshop.exception.UserNameIsUsedException;
import com.bookshop.service.UserService;
import com.bookshop.util.Page;
import com.bookshop.util.configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public boolean checkUserExistedByUserId(Long userId){
        User user = getUser(userId);
        if(user!=null)return true;
        return false;
    }

    /*insert user
    * 插入用户*/
    @Transactional(rollbackOn = Exception.class)
    public  User insertUser (User user) throws Exception {
        if(checkUserExistedByUserName(user.getUserName())){
            /*存在同名用户 注册失败*/
            throw new UserNameIsUsedException(user);
        }else{
            try{
                /*the generated key has been assigned to the property "userId" of object "user" now
                 * 此时数据库生成的主键id返回并且更新到user对象中*/
                userDao.insertUser(user);
            }catch (Exception e){
                e.printStackTrace();
                throw new Exception();
            }
        }
        return user;
    }

    /*delete an user (close an account)
    * 删除用户（注销账号）*/
    public Boolean deleteUser(User user){
        if(userDao.deleteUser(user)!=1)return false;
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
            /*查询用户名*/
            map.put("user_name",user.getUserName());
            map.put("user_password",user.getUserPassword());
            List<User> loginUser = userDao.searchUsers(map);
            if(loginUser!=null||loginUser.size()==1){
                User verifiedUser = loginUser.get(0);
                verifiedUser.setUserPassword("");
                return verifiedUser;
            }else{
                throw new RuntimeException("密码或用户名错误");
            }
        }else{
            throw new RuntimeException("登录错误（user为空）");
        }
    }


    public Page<User> searchUsersPage(Map<String,Object> queryMap){
        Page<User> page = new Page<User>(configs.pageSize);
        queryMap.put("pageSize",configs.pageSize);
        page.setTotalCount(userDao.count(queryMap));
        page.setCurrPage((Integer)queryMap.get("startPage"));
        page.setTotalPage(((Double)Math.ceil(page.getTotalCount()/configs.pageSize)).intValue());
        page.setLists(userDao.searchUsers(queryMap));
        return page;
    }

    @Override
    public User getUser(Long userId) {
        return userDao.getUser(userId);
    }


    @Override
    public Page<User> getAllUsersPage(Integer startPage) {
        HashMap<String,Object> map = new HashMap<>();
        Page<User> page = new Page<User>(configs.pageSize);
        page.setTotalCount(userDao.count(map));
        page.setCurrPage(startPage);
        page.setTotalPage(((Double)Math.ceil(page.getTotalCount()/configs.pageSize)).intValue());
        map.put("pageSize",configs.pageSize);
        map.put("startPage",startPage);
        page.setLists(userDao.getAllUsersPage(map));
        return page;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    /*更新后重新查询查看是否更新成功*/
    @Override
    @Transactional
    public Boolean updateUser(User user) {
        int rows = userDao.updateUser(user);
        if(rows!=1){
            return false;
        }
        return true;
    }

    @Override
    public Integer updateUsers(List<User> users) {
        return userDao.updateUsers(users);
    }



    @Override
    public Integer deleteUsers(List<User> users) {
        /*当影响行数小于用户个数时返回错误*/
        return userDao.deleteUsers(users);
    }

    /*通过id删除user*/
    @Override
    public Boolean deleteUserBytId(Long userId) {
        if(checkUserExistedByUserId(userId)){
            userDao.deleteUserById(userId);
            return true;
        }else{
            return false;
        }
    }

    /*依据map查询个数*/
    public Integer count(Map map){
        return userDao.count(map);
    }

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }
}
