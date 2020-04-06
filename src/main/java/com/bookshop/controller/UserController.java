package com.bookshop.controller;

import com.bookshop.common.responseFromServer;
import com.bookshop.entity.User;
import com.bookshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserController
 * @Description:
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:46
 */

@Controller
@RequestMapping("/user")
public class UserController {
        @Resource
        UserService userService;

    @RequestMapping("/checkLogin")
    @ResponseBody
    public responseFromServer checkLogin(HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user!=null&&user.getUserId()!=null){
            user.setUserPassword("");
            return responseFromServer.success(user);
        }
        return responseFromServer.error();
    }


    @RequestMapping("/register")
    @ResponseBody
    public responseFromServer register(@RequestBody User user, HttpSession session){
        responseFromServer response = userService.insertUser(user);
        if(response.isSuccess()){
            session.setAttribute("user",(User)response.getData());
        }
        return response;
/*        Map<String,Object> result = new HashMap<>();

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
        return result;*/
    }

    @RequestMapping("/registerUsers")
    @ResponseBody
    public responseFromServer registerUsers(@RequestBody List<User> users){
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
        return userService.insertUsers(users);
    }


    /*user要带id*/
    /*todo 删除账号密码校验*/
    @RequestMapping("/closeAccount")
    @ResponseBody
    public responseFromServer closeAccount(@RequestBody  User user) {
        return userService.deleteUser(user);
    }

    @RequestMapping("/setsession")
    @ResponseBody
    public responseFromServer setsession(HttpSession session) {
        session.setAttribute("mysession","fuckyou");
        return responseFromServer.success();
    }

    @RequestMapping("/testsession")
    @ResponseBody
    public responseFromServer testsession(HttpSession session) {
        String user = (String)session.getAttribute("mysession");
        return responseFromServer.success();
    }


    @RequestMapping("/sessiontest")
    @ResponseBody
    public responseFromServer sessionTest(HttpSession session){
        User nowUser = (User)session.getAttribute("user");
        return null;
    }


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public responseFromServer login(@RequestBody  User user,HttpSession session){
        responseFromServer response = userService.login(user);
        if(response.isSuccess()){
            User nowUser = (User)response.getData();
            user.setUserPassword(null);
            session.setAttribute("user",nowUser);
        }
        return response;
    }


    @RequestMapping("/logOut")
    @ResponseBody
    public responseFromServer logOut(HttpSession session){
        if((User)session.getAttribute("user")==null){
            return responseFromServer.error("暂无登录信息");
        }else{
            session.removeAttribute("user");
            return responseFromServer.success();
        }
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public responseFromServer searchUsersPage(@RequestBody User user){
        return userService.getUser(user.getUserId());
    }



    @RequestMapping("/searchUsersPage")
    @ResponseBody
    public responseFromServer searchUsersPage(@RequestBody Map<String,Object> requestMap){
        return userService.searchUsersPage(requestMap);
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public responseFromServer getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/getAllUsersPage")
    @ResponseBody
    public responseFromServer getAllUsersPage(@RequestBody Integer startPage){
        return userService.getAllUsersPage(startPage);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public responseFromServer updateUser(@RequestBody User user){
        return userService.updateUser(user);
        /*if(!userService.updateUser(user)){
            return "error";
        }else{
            return "success";
        }*/
    }

    @RequestMapping("/updateUsers")
    @ResponseBody
    public responseFromServer updateUsers(@RequestBody List<User> users){
        return userService.updateUsers(users);
        /*返回影响行数*/
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public responseFromServer deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
        /*返回删除的行数*/
        /*if(userService.deleteUser(user)){
            return "success";
        }else{
            return "error";
        }*/
    }

    @RequestMapping("/deleteUsers")
    @ResponseBody
    public responseFromServer deleteUsers(List<User> users){
        return userService.deleteUsers(users);
    }
}
