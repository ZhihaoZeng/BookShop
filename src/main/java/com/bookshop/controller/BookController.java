package com.bookshop.controller;

import com.bookshop.entity.Book;
import com.bookshop.service.BookService;
import com.bookshop.util.Page;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BookController
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:48
 */
@RequestMapping("/book")
public class BookController {

    @Resource
    BookService bookService;

    @RequestMapping("/getBook")
    @ResponseBody
    public Book getBook(@RequestBody Long bookId){
        return bookService.getBook(bookId);
    }

    @RequestMapping("/getAllBooks")
    @ResponseBody
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping("/searchBooksPage")
    @ResponseBody
    public Page<Book> searchBooksPage(@RequestBody Map<String,Object> requestMap){
        Book book = (Book)requestMap.get("book");
        HashMap<String,Object> queryMap = book == null?null:book.toMap();
        String startTime = (String) queryMap.get("startTime");
        String endTime = (String) queryMap.get("endTime");
        Double startPrice = (Double) queryMap.get("startPrice");
        Double endPrice = (Double) queryMap.get("endPrice");
        if(startTime!=null && !startTime.equals("")){
            queryMap.put("startTime",startTime);
        }
        if(endTime!=null && !endTime.equals("")){
            queryMap.put("endTime",endTime);
        }
        if(startPrice>0.0){
            queryMap.put("startPrice",startPrice);
        }
        if(endPrice>0.0){
            queryMap.put("endPrice",endPrice);
        }
        return bookService.searchBooksPage(queryMap);

    }

    @RequestMapping("/getAllBooksPage")
    @ResponseBody
    public Page<Book> getAllBooksPage(@RequestBody Integer startPage){
        return bookService.getAllBooksPage(startPage);
    }


    @RequestMapping("/insertBook")
    @ResponseBody
    public Book insertBook(@RequestBody Book book){
        return bookService.insertBook(book);
    }

    @RequestMapping("/updateBook")
    @ResponseBody
    public String updateBook(@RequestBody Book book){
        if(bookService.updateBook(book)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/updateBooks")
    @ResponseBody
    public Integer updateBooks(@RequestBody List<Book> books){
        return bookService.updateBooks(books);
    }


    @RequestMapping("/deleteBookById")
    @ResponseBody
    public String deleteBookById(@RequestBody Long bookId){
        if(bookService.deleteBookById(bookId)){
            return "success";
        }else{
            return "error";
        }
    }


    @RequestMapping("/deleteBook")
    @ResponseBody
    public String deteleBook(@RequestBody Book book){
        if(bookService.deleteBook(book)){
            return "success";
        }else{
            return "error";
        }
    }
    @RequestMapping("/deleteBooks")
    @ResponseBody
    public Integer deleteBooks(@RequestBody List<Book> books){
        return bookService.deleteBooks(books);
    }






}
