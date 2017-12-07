package com.jnmd.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jnmd.dao.BookDao;
import com.jnmd.domain.Book;
import com.jnmd.domain.Page;

@Service
@Transactional
public class BookService {
    @Resource//依赖注入
    private BookDao bookdao;
    
    //事务管理      查询全部书籍
    @Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
    public List<Book> findBook(){
            return bookdao.findBook();
    }
    
    //事务管理    插入书籍
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insertBook(Book book){
        bookdao.insert(book);
    }
    //事务管理   更新书籍
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public void updateBook(Book book,int bid){
        bookdao.update(book, bid);
    }
    
    //事务管理   删除书籍
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public void deleteBook(int bid){
        bookdao.delete(bid);
    }
    
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public Book queryBook(int bid){
        
        return bookdao.queryBook(bid);
        
    }
    public List<Book> queryByPage(Page page){
        return bookdao.queryByPage(page);
    }
}
