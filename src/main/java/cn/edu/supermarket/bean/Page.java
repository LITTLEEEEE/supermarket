package cn.edu.supermarket.bean;

import java.util.List;
import java.util.Map;

public class Page {
    private int code;
    private String msg;
    private Map data;

    public Page() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public Page(int code, String msg, Map data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
