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

    Integer insertOrderItem(OrderItem orderItem);
    Integer insertOrderItems(List<OrderItem> orderItems);

    Integer updateOrderItem(OrderItem orderItem);
    Integer updateOrderItems(List<OrderItem> orderItems);

    Integer deleteOrderItem(OrderItem orderItem);
    Integer deleteOrderItems(List<OrderItem> orderItems);
    Integer deleteOrderItemsByOrderId(Long orderId);
}
