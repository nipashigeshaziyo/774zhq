package com.library.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domain.Book;
import com.library.domain.Page;
import com.library.service.Service;

/**
 * Servlet implementation class Pagechange
 */
@WebServlet("/Pagechange")
public class Pagechange extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	            Page  p = new Page();
	            int currentPage = 1;
	            int PageNum = 5;
	            String s_currentPage = request.getParameter("currentPage");
	            String s_PageNum = request.getParameter("PageNum");
	            if(s_currentPage!=null){
	                currentPage = Integer.parseInt(request.getParameter("currentPage"));
	            }
	            if(s_PageNum!=null){
	                PageNum = Integer.parseInt(request.getParameter("PageNum"));
	            }
	            
	            int totalNum = Service.getCount();
	            int totalPage=(int)Math.ceil(totalNum*1.0/PageNum);
	            
	            List<Book> list=Service.getQueryByPage(currentPage, PageNum);
	            p.setList(list);
	            p.setCurrentPage(currentPage);
	            p.setPageNum(PageNum);
	            p.setTotalNum(totalNum);
	            p.setTotalPage(totalPage);
	            
	            request.setAttribute("page", p);
	            request.getRequestDispatcher("pageDemo.jsp").forward(request, response);
            
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
