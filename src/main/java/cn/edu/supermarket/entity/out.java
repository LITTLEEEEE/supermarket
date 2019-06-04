package cn.edu.supermarket.entity;

import java.sql.Date;

public class out {
    private int pid;
    private int count;
    private Date date;
    private String reason;
    private int outid;

    public out(int pid, int count, Date date, String reason, int outid) {
        this.pid = pid;
        this.count = count;
        this.date = date;
        this.reason = reason;
        this.outid = outid;
    }

    public out() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getOutid() {
        return outid;
    }

    public void setOutid(int outid) {
        this.outid = outid;
    }

    @Override
    public String toString() {
        return "out{" +
                "pid=" + pid +
                ", count=" + count +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                ", outid=" + outid +
                '}';
    }
}
