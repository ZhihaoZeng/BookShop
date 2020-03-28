package com.bookshop.exception;

import com.bookshop.entity.User;

import java.util.List;

/**
 * @ClassName: UserNameIsUsedException
 * @Description: 命名冲突错误
 * @Author: 曾志昊
 * @Date: 2020/3/28 16:57
 */
public class UserNameIsUsedException extends Exception {
    private User user;
    public UserNameIsUsedException(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }
}
