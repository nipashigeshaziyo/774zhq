package com.jnmd.Action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.jnmd.Service.BookService;
import com.jnmd.domain.Book;
import com.jnmd.domain.Page;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("showBookActionByPage")
@Results({ @Result(name = "success", location = "/showBookByPage.jsp") })
public class ShowBookActionByPage extends ActionSupport {
    private Page page;

    private int pageNum=5;

    private int currentNum=1;

    private int totalPage;

    private int totalNum;
    
    public Page getPage() {
        return page;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
    @Resource
    private BookService bookService;
    
    private List<Book> list;
    
    public List<Book> getList() {
        return list;
    }

    @Override
    public String execute() throws Exception {
        totalNum=bookService.findBook().size();
        totalPage=(int)(Math.ceil((totalNum*1.0/pageNum)));
        System.out.println(totalNum);
        page= new Page(pageNum,currentNum,totalPage,totalNum);
        System.out.println(page);
        list=bookService.queryByPage(page);
//        list=bookService.findBook();
        return SUCCESS;
    }
}
