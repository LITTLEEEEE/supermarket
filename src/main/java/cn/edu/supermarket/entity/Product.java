package cn.edu.supermarket.entity;

public class Product {
    private int pid;
    private Type type;
    private int totalcount;
    private String pname;
    private double price;
    private String intro;
    private String img_url;

    public Product() {
    }

    public Product(int pid, Type type, int totalcount, String pname, double price, String intro, String img_url) {
        this.pid = pid;
        this.type = type;
        this.totalcount = totalcount;
        this.pname = pname;
        this.price = price;
        this.intro = intro;
        this.img_url = img_url;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", type=" + type +
                ", totalcount=" + totalcount +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", intro='" + intro + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
