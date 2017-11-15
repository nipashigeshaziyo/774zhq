package com.library.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable{
    private static final long serialVersionUID = 1L;
    private int currentPage;  //当前页
    private int totalPage;      //总页数
    private int totalNum;       //总条数
    private int pageNum;        //每页条数
    private List<Book> list;
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalNum() {
        return totalNum;
    }
    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public List<Book> getList() {
        return list;
    }
    public void setList(List<Book> list) {
        this.list = list;
    }
}
