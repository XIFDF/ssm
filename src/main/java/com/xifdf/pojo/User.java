package com.xifdf.pojo;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String sex;
    private String tel;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getTel() {
        return this.tel;
    }
    public void serTel(String tel) {
        this.tel = tel;
    }
}