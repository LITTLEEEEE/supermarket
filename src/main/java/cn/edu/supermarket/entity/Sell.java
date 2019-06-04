package cn.edu.supermarket.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Sell {
    private Integer sell_id;
    private Integer pid;
    private Integer uid;
    private Integer sell_count;
    private Double sell_price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , timezone = "Asia/Shanghai")
    private Date sell_date;

    public Sell() {
    }

    public Sell(Integer sell_id, Integer pid, Integer uid, Integer sell_count, Double sell_price, Date sell_date) {
        this.sell_id = sell_id;
        this.pid = pid;
        this.uid = uid;
        this.sell_count = sell_count;
        this.sell_price = sell_price;
        this.sell_date = sell_date;
    }

    public Integer getSell_id() {
        return sell_id;
    }

    public void setSell_id(Integer sell_id) {
        this.sell_id = sell_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSell_count() {
        return sell_count;
    }

    public void setSell_count(Integer sell_count) {
        this.sell_count = sell_count;
    }

    public Double getSell_price() {
        return sell_price;
    }

    public void setSell_price(Double sell_price) {
        this.sell_price = sell_price;
    }

    public Date getSell_date() {
        return sell_date;
    }

    public void setSell_date(Date sell_date) {
        this.sell_date = sell_date;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "sell_id=" + sell_id +
                ", pid=" + pid +
                ", uid=" + uid +
                ", sell_count=" + sell_count +
                ", sell_price=" + sell_price +
                ", sell_date=" + sell_date +
                '}';
    }
}
