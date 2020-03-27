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
    public Order getOrder(Long orderId);
    public List<Order> getOrdersByUserId(Long userId);

    public List<Order> searchOrders(Map map);

    public void insertOrder(Order order);
    public void insertOrders(List<Order> orders);

    public void updateOrder(Order order);
    public void updateOrders(List<Order> orders);

    public void deleteOrderById(Long orderId);
    public void deleteOrder(Order order);
    public void deleteOrders(List<Long> orderIds);
}
