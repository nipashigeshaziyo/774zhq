package com.jnmd.Action;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;

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
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("bookListAction")
@Results({
    @Result(name="success",location="/showBooks.vm"),
})
public class BookListAction extends ActionSupport{
    
    
    public BookService getBookservice() {
        return bookservice;
    }
    public void setBookservice(BookService bookservice) {
        this.bookservice = bookservice;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public List<Book> getBooks() {
        return books;
    }
    @Resource
    private BookService bookservice;
    
    private List<Book> books;
    
    @Override
    public String execute() throws Exception {
        books=bookservice.findBook();
        return SUCCESS;
    }
}
