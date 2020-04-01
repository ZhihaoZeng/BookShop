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


    public Cart(List<CartItem> books, Long userId) {
        this.books = books;
        this.userId = userId;
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

}
