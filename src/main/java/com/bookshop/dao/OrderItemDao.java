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

    public List<OrderItem> getOrderItems(Long orderId);
    public List<OrderItem> getOrderItemsPage(Long orderId, Map map);

    public void insertOrderItem(OrderItem orderItem);
    public void insertOrderItems(List<OrderItem> orderItems);

    public void updateOrderItem(OrderItem orderItem);
    public void updateOrderItems(List<OrderItem> orderItems);

    public void deleteOrderItem(OrderItem orderItem);
    public void deleteOrderItems(List<OrderItem> orderItems);

}
