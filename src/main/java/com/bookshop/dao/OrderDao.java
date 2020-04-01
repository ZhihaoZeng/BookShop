package com.bookshop.dao;

import com.bookshop.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: OrderDao
 * @Description: OrderDao
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:52
 */
public interface OrderDao {
    Order getOrder(Long orderId);
    List<Order> getOrdersByUserId(Long userId);
    List<Order> getOrdersPlusByUserId(Long userId);

    List<Order> searchOrders(Map map);

    Integer insertOrder(Order order);
    Integer insertOrders(List<Order> orders);

    Integer updateOrder(Order order);
    Integer updateOrders(List<Order> orders);

    Integer deleteOrderById(Long orderId);
    Integer deleteOrder(Order order);
    void deleteOrders(List<Long> orderIds);

    Integer count(Map map);
}
