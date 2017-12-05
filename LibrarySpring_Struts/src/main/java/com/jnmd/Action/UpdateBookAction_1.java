package com.jnmd.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.jnmd.domain.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("struts-default")
@Action("updateBookAction_1")
@Results({
    @Result(name="success",location="/updatebook.jsp")
})
public class UpdateBookAction_1 extends ActionSupport{
    private int bid;
    
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    private Book book;
    
    private String[] kinds;
    
    private String name;
    
    private String kind;
    
    private String author;
    
    private Double discount;
    
    private Double price;
    
    private int count;
    
    private String introduce;
    
    
    public void setKinds(String[] kinds) {
        this.kinds = kinds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String[] getKinds() {
        return kinds;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    @Override
    public String execute() throws Exception {
        book = new Book(bid,name,kind,author,discount,price,count,introduce);
        String kind=book.getKind();
        kinds=kind.split(" ");
        if(kind.length()<=3){
            kinds[0]=kind.substring(0, kind.length()-1);
        }else{
            kinds=kind.split(" ");            
        }
        return SUCCESS;
    }
}
