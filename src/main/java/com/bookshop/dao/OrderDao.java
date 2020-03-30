package com.bookshop.dao;

import com.bookshop.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: OrderDao
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:52
 */
public interface OrderDao {
    Order getOrder(Long orderId);
    List<Order> getOrdersByUserId(Long userId);
    List<Order> getOrdersPlusByUserId(Long userId);

    List<Order> searchOrders(Map map);

    void insertOrder(Order order);
    void insertOrders(List<Order> orders);

    void updateOrder(Order order);
    void updateOrders(List<Order> orders);

    void deleteOrderById(Long orderId);
    void deleteOrder(Order order);
    void deleteOrders(List<Long> orderIds);
}
