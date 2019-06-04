package cn.edu.supermarket.entity;

import java.sql.Date;

public class Purchase {
    private int pid;
    private int purchase_id;
    private int count;
    private double price;
    private Date date;
    private String intro;
    private int typeid;
    private String pname;

    public Purchase(int pid, int purchase_id, int count, double price, Date date, String intro, int typeid, String pname) {
        this.pid = pid;
        this.purchase_id = purchase_id;
        this.count = count;
        this.price = price;
        this.date = date;
        this.intro = intro;
        this.typeid = typeid;
        this.pname = pname;
    }

    public Purchase() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "pid=" + pid +
                ", purchase_id=" + purchase_id +
                ", count=" + count +
                ", price=" + price +
                ", date=" + date +
                ", intro='" + intro + '\'' +
                ", typeid=" + typeid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
