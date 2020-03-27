package com.bookshop.dao;

import com.bookshop.entity.Book;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: BookDao
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:50
 */

public interface BookDao{
    public Book getBook(Long bookId);//只查询一个数据，常用于修改
    public List<Book> getAllBooksPage(Map map);
    public List<Book> getAllBooks();

    public List<Book> searchBooks(Map map);//根据条件查询多个结果

    public void insertBook(Book book);//插入，用实体作为参数
    public void insertBooks(List<Book> books);//插入，用实体作为参数

    public void updateBook(Book book);//修改，用实体作为参数
    public void updateBooks(List<Book> books);

    public void deleteBookById(Long bookId);//按id删除 删除一条 支持整型和字符串类型id
    public void deleteBook(Book book);
    public void deleteBooks(List<Long> bookIds);//批量删除 支持整型和字符串类型id
}
