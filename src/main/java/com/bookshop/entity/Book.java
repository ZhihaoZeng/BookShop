package com.bookshop.entity;

/**
 * @ClassName: Book
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:55
 */
public class Book {
    private Integer bookId;
    private Double price;
    private String bookName;
    private String detail;
    private String bookType;
    private String image;
    private String publishTime;

    public Book(Integer bookId, Double price, String bookName, String detail, String bookType, String image, String publishTime) {
        this.bookId = bookId;
        this.price = price;
        this.bookName = bookName;
        this.detail = detail;
        this.bookType = bookType;
        this.image = image;
    }

    public Book() {
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
