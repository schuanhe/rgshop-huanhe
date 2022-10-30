package com.rgshop.model;

public class User {
    private Integer Userid;
    private String Name;
    private String Password;
    private String Qq;

    public User(Integer userid, String name, String password, String qq) {
        Userid = userid;
        Name = name;
        Password = password;
        Qq = qq;
    }

    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    public User() {
    }

    public Integer getUserid() {
        return Userid;
    }

    public void setUserid(Integer userid) {
        Userid = userid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getQq() {
        return Qq;
    }

    public void setQq(String qq) {
        Qq = qq;
    }
}
