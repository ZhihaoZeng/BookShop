package com.bookshop.entity;
/**
 * @ClassName: CartItem
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:55
 */
public class CartItem {

    private Long userId;
    private Long bookId;
    private String time;
    private Book book;
    private Integer cartNum;

    public CartItem(Long userId, Long bookId, Book book, Integer cartNum,String time) {
        this.userId = userId;
        this.bookId = bookId;
        this.book = book;
        this.cartNum = cartNum;
        this.time = time;
    }

    public CartItem() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCartNum() {
        return cartNum;
    }

    public void setCartNum(Integer cartNum) {
        this.cartNum = cartNum;
    }
}
