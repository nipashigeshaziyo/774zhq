package com.jnmd.Action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.jnmd.Service.BookService;
import com.jnmd.domain.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("addAction")
@Results({
    @Result(name="success",location="/addBookSuc.jsp"),
    @Result(name="input",location="/addLibrary.jsp")
})
public class AddAction extends ActionSupport{
    
    private String name;
    
    private String kind;
    
    private String author;
    
    private double discount;
    
    private double price;
    
    private int count;
    
    private String introduce;
    
    @RequiredStringValidator(key="error.name.notnull",trim=true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @RequiredStringValidator(key="error.kind.notnull",trim=true)
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    @RequiredStringValidator(key="error.author.notnull",trim=true)
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    
    @DoubleRangeFieldValidator(key="error.discount.notnull",minInclusive="0.0")
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    @DoubleRangeFieldValidator(key="error.price.notnull",minInclusive="0.0000000000001")
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    @IntRangeFieldValidator(key="error.count.notnull",min="1")
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    
    @RequiredStringValidator(key="error.introduce.notnull")
    public String getIntroduce() {
        return introduce;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    
    private String[] kinds;
    public String[] getKinds() {
        return kinds;
    }
    
    @Resource
    private BookService bookservice;
    
    private Book book;
    @Override
    public String execute() throws Exception {
        book = new Book(name,kind,author,discount,price,count,introduce);
        bookservice.insertBook(book);
        return SUCCESS;
    }
    @Override
    public void validate(){
        System.out.println(price);
        if(kinds==null){
           return;
        }
        kinds=kind.split(", ");
        super.validate();
    }
}
