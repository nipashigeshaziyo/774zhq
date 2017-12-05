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
@Action("queryBookAction")
@Results({
    @Result(name="SUCCESS",location="queryBook.jsp")
})
public class QueryBookAction extends ActionSupport{
    
    /*private String name;

    private String kind;

    private String author;

    private double discount;

    private double price;

    private int count;

    private String introduce;

    public int getBid() {
        return bid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }*/
    private int bid;
    public void setBid(int bid) {
        this.bid = bid;
    }
    @Resource
    private BookService bookservice;
    
    private Book book;
    
    public Book getBook() {
        return book;
    }

    @Override
    public String execute() throws Exception {
        book = bookservice.queryBook(bid);
        return SUCCESS;
    }
}
