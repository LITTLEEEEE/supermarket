package cn.edu.supermarket.entity;

public class Type {
    private int tid;
    private String typename;

    public Type() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Type{" +
                "tid=" + tid +
                ", typename='" + typename + '\'' +
                '}';
    }
}
