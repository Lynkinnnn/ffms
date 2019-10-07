package com.wowo.ffms.entity;


import javax.persistence.*;
@Entity//这是一个实体类，和数据表映射的类
@Table(name = "users")//Users数据表 如果省略就是user表(类名小写)
public class User {

    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private int id;

    @Column(name = "name")//这是数据表对应的一个列 省略不写默认是属性名
    private String name;

    @Column(name = "realname")
    private String realName;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "phone")
    private String phone;

    public User() {
    }

    public User(String name, String realName, String pwd, String phone) {
        this.name = name;
        this.realName = realName;
        this.pwd = pwd;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
