package com.bookshop.service;

import com.bookshop.entity.Book;
import com.bookshop.util.Page;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: BookService
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 2:00
 */
public interface BookService {
    public Book getBook(Long bookId);//只查询一个数据，常用于修改
    public Page<Book> getAllBooksPage(Integer startPage);
    public List<Book> getAllBooks();

    public Page<Book> searchBooksPage(Map<String,Object> queryMap);//根据条件查询多个结果

    public Book insertBook(Book book);//插入，用实体作为参数
    public Integer insertBooks(List<Book> books);//插入，用实体作为参数

    public Boolean updateBook(Book book);//修改，用实体作为参数
    public Integer updateBooks(List<Book> books);

    public Boolean deleteBookById(Long bookId);//按id删除 删除一条 支持整型和字符串类型id
    public Boolean deleteBook(Book book);
    public Integer deleteBooks(List<Book> bookIds);//批量删除 支持整型和字符串类型id

}
