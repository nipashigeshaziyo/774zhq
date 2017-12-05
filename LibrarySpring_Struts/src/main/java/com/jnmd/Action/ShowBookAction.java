package com.jnmd.Action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.jnmd.Service.BookService;
import com.jnmd.domain.Book;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("struts-default")
@Action("showBookAction")
@Results({
    @Result(name ="success",location="/showBook.jsp")
})
public class ShowBookAction extends ActionSupport{
    private int bid;
    
    @Resource
    private BookService bookservice;
    
    public void setBid(int bid) {
        this.bid = bid;
    }
    
    private Book book;
    
    public Book getBook() {
        return book;
    }
    
    @Override
    public String execute() throws Exception {
        book=bookservice.queryBook(bid);
        return SUCCESS;
    }
}
