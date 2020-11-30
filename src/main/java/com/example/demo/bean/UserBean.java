package com.example.demo.bean;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 夏龙
 * @date 2020-11-26
 */
@Entity
@Table(name = "user", schema = "test", catalog = "")
public class UserBean {
    private String id;
    private String name;
    private String password;
    private String userType;
    private String sex;
    private String csrq;
    private String hobby;
    private String email;
    private String describe;
    public UserBean(){
        super();
    }
    public UserBean(String id, String name, String password, String userType, String sex, String csrq, String hobby, String email, String describe) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userType = userType;
        this.sex = sex;
        this.csrq = csrq;
        this.hobby = hobby;
        this.email = email;
        this.describe = describe;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "userType")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "csrq")
    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    @Basic
    @Column(name = "hobby")
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "describe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBean userBeanx = (UserBean) o;
        return Objects.equals(id, userBeanx.id) &&
                Objects.equals(name, userBeanx.name) &&
                Objects.equals(password, userBeanx.password) &&
                Objects.equals(userType, userBeanx.userType) &&
                Objects.equals(sex, userBeanx.sex) &&
                Objects.equals(csrq, userBeanx.csrq) &&
                Objects.equals(hobby, userBeanx.hobby) &&
                Objects.equals(email, userBeanx.email) &&
                Objects.equals(describe, userBeanx.describe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, userType, sex, csrq, hobby, email, describe);
    }
}
