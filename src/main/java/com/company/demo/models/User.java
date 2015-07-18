package com.company.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String email;

    @NotNull
    private String name;

    private String phone;

    private String address;

    @Column(name = "picture_id")
    @NotNull
    private long pictureId;

    private boolean status;

    private Date updateTime;

    public User() {
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public User(String name, String email, String phone, String address, long pictureId, boolean status, Date updateTime) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.pictureId = pictureId;
        this.status = status;
        this.updateTime = updateTime;
    }


    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getPictureId() {

        return pictureId;
    }

    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }
}
