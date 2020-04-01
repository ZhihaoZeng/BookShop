package com.bookshop.controller;

import com.bookshop.common.responseFromServer;
import com.bookshop.entity.Book;
import com.bookshop.service.BookService;
import com.bookshop.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BookController
 * @Description:
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:48
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    BookService bookService;

    @RequestMapping("/getBook")
    @ResponseBody
    public responseFromServer getBook(@RequestBody Long bookId){
        return bookService.getBook(bookId);
    }


    @RequestMapping("/searchBooksPage")
    @ResponseBody
    public responseFromServer searchBooksPage(@RequestBody Map<String,Object> requestMap){
        return bookService.searchBooksPage(requestMap);
    }

    @RequestMapping("/getAllBooksPage")
    @ResponseBody
    public responseFromServer getAllBooksPage(@RequestBody Map<String,Object> queryMap){
        return bookService.getAllBooksPage(queryMap);
    }


    @RequestMapping("/insertBook")
    @ResponseBody
    public responseFromServer insertBook(@RequestBody Book book){
        return bookService.insertBook(book);
    }

    @RequestMapping("/updateBook")
    @ResponseBody
    public responseFromServer updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @RequestMapping("/updateBooks")
    @ResponseBody
    public responseFromServer updateBooks(@RequestBody List<Book> books){
        return bookService.updateBooks(books);
    }


    @RequestMapping("/deleteBookById")
    @ResponseBody
    public responseFromServer deleteBookById(@RequestBody Long bookId){
        return bookService.deleteBookById(bookId);
    }


    @RequestMapping("/deleteBook")
    @ResponseBody
    public responseFromServer deteleBook(@RequestBody Book book){
        return bookService.deleteBook(book);
    }
    @RequestMapping("/deleteBooks")
    @ResponseBody
    public responseFromServer deleteBooks(@RequestBody List<Book> books){
        return bookService.deleteBooks(books);
    }

}
