package com.bookshop.entity;

import java.util.List;

/**
 * @ClassName: Cart
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:55
 */
public class Cart {
    //购物车书本
    private List<CartItem> books;
    private Long userId;
    private Integer totalPrice;

    public Cart(List<CartItem> books, Long userId, Integer totalPrice) {
        this.books = books;
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    public Cart() {
    }

    public List<CartItem> getBooks() {
        return books;
    }

    public void setBooks(List<CartItem> books) {
        this.books = books;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
