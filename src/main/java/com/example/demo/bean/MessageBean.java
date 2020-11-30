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
    private String id;
    private String message;
    private Timestamp date;
    public MessageBean() {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public MessageBean(String id, String message, Timestamp date) {
        this.id = id;
        this.message = message;
        this.date = date;
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
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, date);
    }


}
