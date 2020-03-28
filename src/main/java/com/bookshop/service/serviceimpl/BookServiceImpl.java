package com.bookshop.service.serviceimpl;

import com.bookshop.dao.BookDao;
import com.bookshop.entity.Book;
import com.bookshop.service.BookService;
import com.bookshop.util.Page;
import com.bookshop.util.configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BookServiceImpl
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 2:01
 */
@Service
public class BookServiceImpl {

    private BookDao bookDao;

    public Book getBook(Long bookId){
        return bookDao.getBook(bookId);
    }

    public List<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }

    public Page<Book> getAllBooksPage(Integer startPage){
        Map<String,Object> map = new HashMap<>();
        map.put("startPage",startPage);
        map.put("pageSize",configs.pageSize);
        Page<Book> page = new Page<Book>(configs.pageSize);
        page.setTotalCount(bookDao.count(map));
        page.setTotalPage(((Double)Math.ceil(page.getTotalCount()/configs.pageSize)).intValue());
        page.setLists(bookDao.getAllBooksPage(map));
        return page;
    }

    public Page<Book> searchBooksPage(Map<String,Object> queryMap){
        Page<Book> page = new Page<Book>(configs.pageSize);
        queryMap.put("pageSize",configs.pageSize);
        page.setTotalCount(bookDao.count(queryMap));
        page.setCurrPage((Integer)queryMap.get("startPage"));
        page.setTotalPage(((Double)Math.ceil(page.getTotalCount()/configs.pageSize)).intValue());
        page.setLists(bookDao.searchBooks(queryMap));
        return page;
    }

    public Book insertBook(Book book){
        if(bookDao.insertBook(book)==1){
            return book;
        }else{
            /*插入失败*/
            return null;
        }
    }


    /*TODO*/
    public Integer insertBooks(List<Book> books){
        int result = 0;
        for(Book book:books){
            if(bookDao.insertBook(book)==1){
                result++;
            }
        }
        return result;
    }

    public Boolean updateBook(Book book){
        if(bookDao.updateBook(book)==1){
            return true;
        }else{
            return false;
        }
    }

    public Integer updateBooks(List<Book> books){
        return bookDao.updateBooks(books);
    }

    public Boolean deleteBookById(Long bookId){
        if(bookDao.deleteBookById(bookId)==1){
            return true;
        }else{
            return false;
        }
    }


    public Boolean deleteBook(Book book){
        if(bookDao.deleteBook(book)==1){
            return true;
        }else{
            return false;
        }
    }

    public Integer deleteBooks(List<Book> books){
        return bookDao.deleteBooks(books);
    }




    @Autowired
    public BookServiceImpl(BookDao bookDao){
        this.bookDao = bookDao;
    }
}
