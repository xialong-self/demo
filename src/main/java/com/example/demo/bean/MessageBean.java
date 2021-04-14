package com.example.demo.bean;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author 夏龙
 * @date 2020-11-23
 */
@Entity
@Table(name = "message", schema = "test")
public class MessageBean {
    private Integer id;
    private String message;
    private String httpms;
    private String xt_lrxm;
    private String xt_lrsj;
    private Timestamp date;
    public MessageBean() {
        this.id = id;
        this.message = message;
        this.httpms = httpms;
        this.xt_lrxm = xt_lrxm;
        this.xt_lrsj = xt_lrsj;
        this.date = date;
    }

    public MessageBean(Integer id, String message,String httpms,String xt_lrsj,String xt_lrxm, Timestamp date) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.httpms = httpms;
        this.xt_lrxm = xt_lrxm;
        this.xt_lrsj = xt_lrsj;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "httpms")
    public String getHttpms() {
        return httpms;
    }

    public void setHttpms(String httpms) {
        this.httpms = httpms;
    }

    @Basic
    @Column(name = "xt_lrxm")
    public String getXtlrxm() {
        return xt_lrxm;
    }

    public void setXtlrxm(String xt_lrxm) {
        this.xt_lrxm = xt_lrxm;
    }

    @Basic
    @Column(name = "xt_lrsj")
    public String getXtlrsj() {
        return xt_lrsj;
    }

    public void setXtlrsj(String xt_lrsj) {
        this.xt_lrsj = xt_lrsj;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageBean that = (MessageBean) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(message, that.message) &&
                Objects.equals(date, that.date) &&
                Objects.equals(httpms, that.httpms) &&
                Objects.equals(xt_lrsj, that.xt_lrsj) &&
                Objects.equals(xt_lrxm, that.xt_lrxm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, date,httpms,xt_lrsj,xt_lrxm);
    }


}
