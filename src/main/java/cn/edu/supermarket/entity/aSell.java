package cn.edu.supermarket.entity;

import java.sql.Date;

public class aSell {
    private int pid;
    private int userid;
    private int typeid;
    private double price;
    private Date date;
    private String pname;
    private int count;

    public aSell(int pid, int userid, int typeid, double price, Date date, String pname, int count) {
        this.pid = pid;
        this.userid = userid;
        this.typeid = typeid;
        this.price = price;
        this.date = date;
        this.pname = pname;
        this.count = count;
    }

    public aSell() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "aSell{" +
                "pid=" + pid +
                ", userid=" + userid +
                ", typeid=" + typeid +
                ", price=" + price +
                ", date=" + date +
                ", pname='" + pname + '\'' +
                ", count=" + count +
                '}';
    }
}
