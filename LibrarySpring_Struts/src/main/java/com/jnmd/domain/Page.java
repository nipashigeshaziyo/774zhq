package com.jnmd.domain;


public class Page {
    private static int pageNum;
    private static int currentNum ;
    private static int totalPage;
    private static int totalNum;
    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getCurrentNum() {
        return currentNum;
    }
    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalNum() {
        return totalNum;
    }
    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
    public Page(int pageNum, int currentNum, int totalPage, int totalNum) {
        super();
        this.pageNum = pageNum;
        this.currentNum = currentNum;
        this.totalPage = totalPage;
        this.totalNum = totalNum;
    }
    public Page() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "Page [getPageNum()=" + getPageNum() + ", getCurrentNum()=" + getCurrentNum()
                + ", getTotalPage()=" + getTotalPage() + ", getTotalNum()=" + getTotalNum()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
    
}
