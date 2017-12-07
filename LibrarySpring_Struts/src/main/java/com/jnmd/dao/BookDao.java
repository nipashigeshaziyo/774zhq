package com.jnmd.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jnmd.domain.Book;
import com.jnmd.domain.Page;

@Repository
public class BookDao {
    @Resource
    private HibernateTemplate hibernateTemplate;
    
    public void insert(final Book book){
        hibernateTemplate.save(book);
    }
    public Book queryBook(int bid){
        return hibernateTemplate.get(Book.class, bid);
    }
    public List<Book> findBook(){
        return hibernateTemplate.execute(new HibernateCallback(){

                @Override
                public Object doInHibernate(Session session) throws HibernateException {
                        String hql = "from Book";
                        Query query = session.createQuery(hql);
                        List list = query.list();
                        return list;
                }
                
        });
    }
    
    public void update(final Book book,final int bid){
        hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String hql="update book set name=?,kind=?,author=?,discount=?,price=?,count=?,introduce=? where bid=?";
                Query query = session.createSQLQuery(hql);
                query.setString(0,book.getName());
                query.setString(1,book.getKind());
                query.setString(2,book.getAuthor());
                query.setDouble(3,book.getDiscount());
                query.setDouble(4,book.getPrice());
                query.setInteger(5,book.getCount());
                query.setString(6,book.getIntroduce());
                query.setInteger(7,bid);
                query.executeUpdate();
                return null;
            }
        });
    }
    
    public void delete(final int bid){
        hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String hql="delete from book where bid=?";
                Query query = session.createSQLQuery(hql);
                query.setInteger(0,bid);
                query.executeUpdate();
                return null;
            }
            
        });
    }
    public List<Book> queryByPage(final Page page){
        return hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("from Book");
                query.setFirstResult((page.getCurrentNum()-1)*page.getPageNum());
                System.out.println(page.getPageNum());
                query.setMaxResults(page.getPageNum());
                List<Book> list = query.list();
                return list;
            }
        });
    }
}
