package com.bookshop.entity;

/**
 * @ClassName: OrderItem
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:59
 */
public class OrderItem {
    private Long orderId;
    private Long bookId;
    private Integer orderNum;
    private String orderItemStatus;
    private Book book;

    public OrderItem(Long orderId, Long bookId, Integer orderNum, String orderItemStatus, Book book) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.orderNum = orderNum;
        this.orderItemStatus = orderItemStatus;
        this.book = book;
    }

    public String getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(String orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public OrderItem() {
    }
}
