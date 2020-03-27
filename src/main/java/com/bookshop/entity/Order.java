package com.bookshop.entity;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: Order
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:57
 */
public class Order {
    private Long orderId;
    private Long userId;
    private String orderStatus;//订单状态
    private String orderAddress;//订单地址
    private List<OrderItem> books;
    private User user;
    private String purchaseTime;

    public Order(Long orderId, Long userId, String orderStatus, String orderAddress, List<OrderItem> books, User user, String purchaseTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.orderAddress = orderAddress;
        this.books = books;
        this.user = user;
        this.purchaseTime = purchaseTime;
    }

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public List<OrderItem> getBooks() {
        return books;
    }

    public void setBooks(List<OrderItem> books) {
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}
