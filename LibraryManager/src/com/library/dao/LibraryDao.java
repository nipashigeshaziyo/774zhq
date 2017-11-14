package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.domain.Book;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class LibraryDao {
    public static List<Book> Query(){
        ComboPooledDataSource  ds= new ComboPooledDataSource();
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<Book>();
        try {
            conn=ds.getConnection();
            String sql = "select * from book";
            ps =conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt(1);
                String name = rs.getString(2);
                String kind = rs.getString(3);
                String author= rs.getString(4);
                double discount = rs.getDouble(5);
                double price = rs.getDouble(6);
                int count = rs.getInt(7);
                String introduce = rs.getString(8);
                Book book = new Book(id,name,kind,author,discount,price,count,introduce);
                list.add(book);
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                if(rs!=null)
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(ps!=null)
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(conn!=null)
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        throw new RuntimeException("≤È’“ ß∞‹");
    }
    
    public static Book Query(int id){
        ComboPooledDataSource  ds= new ComboPooledDataSource();
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs= null;
        try {
            conn=ds.getConnection();
            String sql = "select * from book where bid="+id;
            ps =conn.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            int bid = rs.getInt(1);
            String name = rs.getString(2);
            String kind = rs.getString(3);
            String author= rs.getString(4);
            double discount = rs.getDouble(5);
            double price = rs.getDouble(6);
            int count = rs.getInt(7);
            String introduce = rs.getString(8);
            Book book = new Book(bid,name,kind,author,discount,price,count,introduce);
            return book;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                if(ps!=null)
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(conn!=null)
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        throw new RuntimeException("≤È’“ ß∞‹");
    }
    
    public static void delete(int id){
        ComboPooledDataSource  ds= new ComboPooledDataSource();
        Connection conn = null;
        PreparedStatement ps=null;
        
        try {
            conn=ds.getConnection();
            String sql = "delete from book where bid ="+id;
            ps =conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                if(ps!=null)
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(conn!=null)
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public static void update(Book book,int id){
        ComboPooledDataSource  ds= new ComboPooledDataSource();
        Connection conn = null;
        PreparedStatement ps=null;
        
        try {
            conn=ds.getConnection();
            String sql = "update book set name='"+book.getName()+"',kind='"+book.getKind()+"',author='"+book.getAuthor()+"',discount="+book.getDiscount()+",price= "+book.getPrice()+",count="+book.getCount()+",introduce='"+book.getIntroduce()+"' where bid = "+id;
            ps =conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                if(ps!=null)
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(conn!=null)
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public static void insert(Book book){
        ComboPooledDataSource  ds= new ComboPooledDataSource();
        Connection conn = null;
        PreparedStatement ps=null;
        
        try {
            conn=ds.getConnection();
            String sql = "insert into book (name,kind,author,discount,price,count,introduce)values ('"+book.getName()+"','"+book.getKind()+"','"+book.getAuthor()+"','"+book.getDiscount()+"',"
                    + "'"+book.getPrice()+"','"+book.getCount()+"','"+book.getIntroduce()+"')";
            ps =conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                if(ps!=null)
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(conn!=null)
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
