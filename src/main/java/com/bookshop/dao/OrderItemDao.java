package com.bookshop.dao;

import com.bookshop.entity.OrderItem;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: OrderItemDao
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:52
 */
public interface OrderItemDao {

    List<OrderItem> getOrderItems(Long orderId);
    List<OrderItem> getOrderItemsPage(Long orderId, Map map);

    void insertOrderItem(OrderItem orderItem);
    void insertOrderItems(List<OrderItem> orderItems);

    void updateOrderItem(OrderItem orderItem);
    void updateOrderItems(List<OrderItem> orderItems);

    void deleteOrderItem(OrderItem orderItem);
    void deleteOrderItems(List<OrderItem> orderItems);

}
