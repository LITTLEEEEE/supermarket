package cn.edu.supermarket.bean;

import java.util.List;
import java.util.Map;

public class listPage {
    private int code;
    private String msg;
    private List data;

    public listPage(int code, String msg, List data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public listPage() {
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

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "listPage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
