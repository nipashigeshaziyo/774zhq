package com.library.domain;

import java.io.Serializable;

public class Book implements Serializable{
    private static final long serialVersionUID = 1L;
    private int bid;
    private String name;
    private String kind;
    private String author;
    private double discount;
    private double price;
    private int count;
    private String introduce;
    public Book(){
        
    }
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
    public void setPrice(float price) {
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
}

