package com.bookshop.entity;

/**
 * @ClassName: User
 * @Description:
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:56
 */
public class Review {
    private Integer reviewId;
    private Integer userId;//???????
    private Integer bookId;
    private String reviewBody;
    private Integer positiveVoteNum;
    private Integer negativeVoteNum;
}
