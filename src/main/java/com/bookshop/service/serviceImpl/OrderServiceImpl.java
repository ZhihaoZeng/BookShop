package com.bookshop.service.serviceImpl;

import com.bookshop.common.responseFromServer;
import com.bookshop.dao.OrderDao;
import com.bookshop.dao.OrderItemDao;
import com.bookshop.dao.UserDao;
import com.bookshop.entity.Order;
import com.bookshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: OrderServiceImpl
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 2:02
 */
@Service(value = "OrderService")
public class OrderServiceImpl implements OrderService {

    UserDao userDao;
    OrderDao orderDao;
    OrderItemDao orderItemDao;

    public responseFromServer getOrder(Long orderId){
        Order order = orderDao.getOrder(orderId);
        if(order!=null)
            return responseFromServer.success(orderDao.getOrder(orderId));
        else
            return responseFromServer.error("不存在该订单");
    }

    public responseFromServer getOrdersByUserId(Long userId){
        if(userDao.getUser(userId)==null){
            return responseFromServer.error("不存在该用户");
        }else{
            List<Order> orders = orderDao.getOrdersByUserId(userId);
            return responseFromServer.success(orders);
        }
    }

    public responseFromServer getOrdersPlusByUserId(Long userId){
//        TODO：分页
        if(userDao.getUser(userId)==null){
            return responseFromServer.error("不存在该用户");
        }else{
            List<Order> orders = orderDao.getOrdersPlusByUserId(userId);
            return responseFromServer.success(orders);
        }
    }



    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderItemDao orderItemDao,UserDao userDao){
        this.userDao = userDao;
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
    }
}
