package cn.edu.supermarket.entity;

public class User {
    private int userid;
    private int type;
    private String username;

    public User() {
    }

    public User(int userid, int type, String username) {
        this.userid = userid;
        this.type = type;

        this.username = username;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", type=" + type +
                ", username='" + username + '\'' +
                '}';
    }
}
