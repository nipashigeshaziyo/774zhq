package com.jnmd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int bid;
    
    private String name;

    private String kind;

    private String author;

    private double discount;

    private double price;

    private int count;

    private String introduce;

    
    
    public Book(int bid, String name, String kind, String author, double discount, double price, int count,
            String introduce) {
        super();
        this.bid = bid;
        this.name = name;
        this.kind = kind;
        this.author = author;
        this.discount = discount;
        this.price = price;
        this.count = count;
        this.introduce = introduce;
    }
    
    
    public Book(String name, String kind, String author, double discount, double price, int count,
            String introduce) {
        super();
        this.name = name;
        this.kind = kind;
        this.author = author;
        this.discount = discount;
        this.price = price;
        this.count = count;
        this.introduce = introduce;
    }


    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public int getBid() {
        return bid;
    }


    public void setBid(int bid) {
        this.bid = bid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }


    @Override
    public String toString() {
        return "Book [bid=" + bid + ", name=" + name + ", kind=" + kind + ", author=" + author + ", discount="
                + discount + ", price=" + price + ", count=" + count + ", introduce=" + introduce + "]";
    }
    
}
