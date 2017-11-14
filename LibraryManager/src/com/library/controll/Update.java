package com.library.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.domain.Book;
import com.library.service.Service;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;utf-8");
            HttpSession session =request.getSession();
            int id = (int)session.getAttribute("bid");
            List<String> error = new ArrayList<String>();
            String name=request.getParameter("name");
            String[] kinds=null;
            kinds=request.getParameterValues("kind");
            String kind="";
            if(kinds!=null){                
                for(int i=0;i<kinds.length;i++){
                    kind +=kinds[i]+" ";
                }
            }
            String author=request.getParameter("author");
            Double discount = Double.parseDouble(request.getParameter("discount"));
            int count =0;
            Double price = 0.0;
            String introduce = request.getParameter("introduce");
            boolean flag=true;
            if(name==null||"".equals(name)){
                error.add("��������Ϊ�գ����������롣");
                flag=false;
            }else{
                error.add("");
            }
            
            if("".equals(kind)||kind==null){
                error.add("��ѡ��һ�����");
                flag=false;
            }else{
                error.add("");
            }
            
            if(author==null||"".equals(author)){
                error.add("���߲���Ϊ�գ����������롣");
                flag=false;
            }else{
                error.add("");
            }
            
            try{
                count = Integer.parseInt(request.getParameter("count"));
            }catch(NumberFormatException e){
                error.add("������һ�����֡�");
                flag=false;
            }
            if(count==0){
                error.add("���������0������");
                flag=false;
            }else{
                error.add("");
            }
            
            try{
                price=Double.parseDouble(request.getParameter("price"));
            }catch(NumberFormatException e ){
                error.add("���������֡�");
                flag=false;
            }
            if(price<=0){
                error.add("���������0������");
                flag=false;
            }else{
                error.add("");
            }
            if(introduce==null||"".equals(introduce)){
                error.add("����д��顣");
                flag=false;
            }else{
                error.add("");
            }
            
            if(flag==false){
                request.setAttribute("error", error);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }else{
                Book book = new Book(name,kind,author,discount,price,count,introduce);
                Service.getupdate(book, id);
                request.getRequestDispatcher("updatesuccess.jsp").forward(request, response);
            }
            
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
