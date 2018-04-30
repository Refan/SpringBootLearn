package com.example.jpajoin.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accountM")
public class AccountMModel implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ac_id;
    private String userId;
    private String payPwd;
    private Integer count;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getAc_id() {
        return ac_id;
    }

    public void setAc_id(Integer ac_id) {
        this.ac_id = ac_id;
    }

    @Override
    public String toString() {
        return "AccountMModel{" +
                "userId='" + userId + '\'' +
                ", payPwd='" + payPwd + '\'' +
                ", count=" + count +
                ", ac_id=" + ac_id +
                '}';
    }
}
