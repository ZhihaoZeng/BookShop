package com.bookshop.controller;

import com.bookshop.dao.OrderDao;
import com.bookshop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:47
 */
@Controller
@RequestMapping("/order")
public class OrderController{

    @Resource
    OrderService orderService;


}
