package com.bookshop.util;


import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @ClassName: Page
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 20:08
 */

public class Page<T> {
    private int startPage;//当前页数
    private int pageSize ;//每页显示的记录数
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private List<T> lists;//每页的显示的数据
    public Page() {
        super();
        pageSize = configs.pageSize;
    }

    public Page(int pageSize){
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return startPage;
    }

    public void setCurrPage(int startPage) {
        this.startPage = startPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

}
