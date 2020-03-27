package com.bookshop.controller;

import com.bookshop.entity.User;
import com.bookshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
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
    public Object register(@RequestParam("user") User user){
        Map<String,Object> result = new HashMap<>();
        /*find if there exists registered user with the same name
         * 查找是否存在有相同用户名的已注册用户*/
        if(userService.checkUserExistedByUserName(user.getUserName())){
            result.put("error","该用户名已被注册！");
            result.put("user",null);
            return result;
        }
        user = userService.insertUser(user);
        result.put("user",user);
        return result;
/**
 * @Author: 曾志昊
 * @Date:   2020/3/28 1:40
 * @Return: java.lang.Object
 * @Description:
 */
    }

    @RequestMapping("/closeAccount")
    @ResponseBody
    public User closeAccount(@RequestParam("user") User user) {
        Map<String, Object> result = new HashMap<>();
        if(userService.checkUserExistedByUserName(user.getUserName())) {
            userService.deleteUser(user);
            return user;
        } else {
            return null;//注销失败
        }
    }


    @RequestMapping("/login")
    @ResponseBody
    public User login(@RequestParam("user") User user){
        user = userService.login(user);
        return user;
        /*if user is null, login fails
         * user为空则表示登录失败*/

    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public User getAllUsers(Integer startPage){
        return null;
    }


}
