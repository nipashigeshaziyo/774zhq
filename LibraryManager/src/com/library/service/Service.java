package com.library.service;

import java.util.ArrayList;
import java.util.List;

import com.library.dao.LibraryDao;
import com.library.domain.Book;

public class Service {
    private static Service s = new  Service();
    private Service(){}
    public static Service getService(){
        return s;
    }
    public static List<Book> getQuery(){
        return LibraryDao.Query();
    }
    public static void getDelete(int id){
        LibraryDao.delete(id);
    }
    public static void getInsert(Book book){
        LibraryDao.insert(book);
    }
    public static Book getQuery(int id){
        return LibraryDao.Query(id);
    }
    public static void getupdate(Book book,int id){
        LibraryDao.update(book, id);
    }
    public static List<Book> getQueryByPage(int currentPage,int PageNum){
        return LibraryDao.QueryByPage(currentPage, PageNum);
    }
    public static int getCount(){
        return LibraryDao.PageCount();
    }
}
