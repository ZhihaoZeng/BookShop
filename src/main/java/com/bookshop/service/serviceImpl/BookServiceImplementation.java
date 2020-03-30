package com.bookshop.service.serviceImpl;

import com.bookshop.entity.Book;
import com.bookshop.service.BookService;
import com.bookshop.util.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: BookServiceImplementation
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/30 16:28
 */
@Service(value = "BookService")
public class BookServiceImplementation implements BookService {

    @Override
    public Book getBook(Long bookId) {
        return null;
    }

    @Override
    public Page<Book> getAllBooksPage(Integer startPage) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Page<Book> searchBooksPage(Map<String, Object> queryMap) {
        return null;
    }

    @Override
    public Book insertBook(Book book) {
        return null;
    }

    @Override
    public Integer insertBooks(List<Book> books) {
        return null;
    }

    @Override
    public Boolean updateBook(Book book) {
        return null;
    }

    @Override
    public Integer updateBooks(List<Book> books) {
        return null;
    }

    @Override
    public Boolean deleteBookById(Long bookId) {
        return null;
    }

    @Override
    public Boolean deleteBook(Book book) {
        return null;
    }

    @Override
    public Integer deleteBooks(List<Book> bookIds) {
        return null;
    }
}
