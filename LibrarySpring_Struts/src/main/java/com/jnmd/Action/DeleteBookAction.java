package com.jnmd.Action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.jnmd.Service.BookService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("struts-default")
@Action("deleteBookAction")
@Results({
    @Result(name="success",location="/deleteSuc.jsp")
})
public class DeleteBookAction extends ActionSupport{
    @Resource
    private BookService bookservice;
    
    private int bid;
    public void setBid(int bid) {
        this.bid = bid;
    }
    @Override
    public String execute() throws Exception {
        bookservice.deleteBook(bid);
        return SUCCESS;
    }
}
