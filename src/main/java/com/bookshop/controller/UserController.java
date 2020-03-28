package com.bookshop.controller;

import com.bookshop.entity.User;
import com.bookshop.exception.UserNameIsUsedException;
import com.bookshop.service.UserService;
import com.bookshop.util.Page;
import com.bookshop.util.configs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:46
 */

@Controller
@RequestMapping("/user")
public class UserController {
        @Resource
        UserService userService;

    /**
     * @Author: 曾志昊
     * @Date:   2020/3/28 1:40
     * @Return:
     * @Description:
     */
    @RequestMapping("/register")
    @ResponseBody
    public Map<String,Object> register(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        /*find if there exists registered user with the same name
         * 查找是否存在有相同用户名的已注册用户*/
        /*        if(userService.checkUserExistedByUserName(user.getUserName())){
            result.put("error","该用户名已被注册！");
            result.put("user",null);
            return result;
        }*/
        /*user为空说明注册失败*/
        try{
            user = userService.insertUser(user);
        }catch(UserNameIsUsedException e){
            user = null;
            result.put("error","用户名被占用");
        }catch(Exception e){
            user = null;
            result.put("error","注册失败");
        }
        result.put("user",user);
        return result;
    }


    @RequestMapping("/registerUsers")
    @ResponseBody
    public Map<String,Object> registerUsers(@RequestBody List<User> users){
        Map<String,Object> result = new HashMap<>();
        List<User> errorUsers = new ArrayList<>();
        for (User user:users) {
            try{
                userService.insertUser(user);
            }catch(Exception e){
                errorUsers.add(user);
            }
        }
        if(errorUsers.size()>0){
            result.put("error","批量注册用户失败");
            result.put("errorUsers",errorUsers);
        }
        return result;
    }



    @RequestMapping("/closeAccount")
    @ResponseBody
    public User closeAccount(@RequestBody  User user) {
        Map<String, Object> result = new HashMap<>();
        if(userService.checkUserExistedByUserName(user.getUserName())) {
            userService.deleteUser(user);
            return user;
        } else {
            return null;//注销失败
        }
    }


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public User login(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        try{
            user = userService.login(user);
        }catch(RuntimeException e){
            user = null;
            result.put("error",e.getMessage());
            e.printStackTrace();
        }
        result.put("user",user);
        return user;
        /*if user is null, login fails
         * user为空则表示登录失败*/
    }


    @RequestMapping("/searchUsers")
    @ResponseBody
    public Page<User> searchUsersPage(@RequestBody Map<String,Object> requestMap
                                  /*User user,
                                   Double startPrice,
                                   Double endPrice,
                                   String startTime,
                                   String endTime*/){
        User user = (User)requestMap.get("user");
        Map<String,Object> queryMap = user.toMap();
        Integer startPage = 0;
        if(queryMap.containsKey("startPage")){
            startPage =  (Integer) queryMap.get("startPage");
        }
        queryMap.put("startPage",startPage);
        /*        Double startPrice = (Double)requestMap.get("startPrice");
        Double endPrice = (Double)requestMap.get("endPrice");
        String startTime = (String)requestMap.get("startTime");
        String endTime = (String)requestMap.get("endTime");
        Map<String,Object> map = new HashMap<>();
        if(startTime!=null && !startTime.equals("")){
            map.put("startTime",startTime);
        }
        if(endTime!=null && !endTime.equals("")){
            map.put("endTime",endTime);
        }
        if(startPrice>0.0){
            map.put("startPrice",startPrice);
        }
        if(endPrice>0.0){
            map.put("endPrice",endPrice);
        }
        map.put("user",user);*/
        Page<User> users = userService.searchUsersPage(queryMap);
        return users;
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/getAllUsersPage")
    @ResponseBody
    public Page<User> getAllUsersPage(@RequestBody Integer startPage){
        return userService.getAllUsersPage(startPage);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(@RequestBody User user){
        if(!userService.updateUser(user)){
            return "error";
        }else{
            return "success";
        }
    }

    @RequestMapping("/updateUsers")
    @ResponseBody
    public Integer updateUsers(@RequestBody List<User> users){
        return userService.updateUsers(users);
        /*返回影响行数*/
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestBody User user){
        /*返回删除的行数*/
        if(userService.deleteUser(user)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/deleteUsers")
    @ResponseBody
    public Integer deleteUsers(List<User> users){
        return userService.deleteUsers(users);
        /*返回影响行数*/
    }


}
