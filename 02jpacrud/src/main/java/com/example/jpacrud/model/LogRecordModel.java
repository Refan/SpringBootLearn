package com.example.jpacrud.model;

import javax.persistence.*;

@Entity
@Table(name = "logRecord")
public class LogRecordModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String tables;
    private String action;
    private String valueBefore;
    private String valueAfter;
    private String creater;
    private String createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getValueBefore() {
        return valueBefore;
    }

    public void setValueBefore(String valueBefore) {
        this.valueBefore = valueBefore;
    }

    public String getValueAfter() {
        return valueAfter;
    }

    public void setValueAfter(String valueAfter) {
        this.valueAfter = valueAfter;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "LogRecordModel{" +
                "id=" + id +
                ", tables='" + tables + '\'' +
                ", action='" + action + '\'' +
                ", valueBefore='" + valueBefore + '\'' +
                ", valueAfter='" + valueAfter + '\'' +
                ", creater='" + creater + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
