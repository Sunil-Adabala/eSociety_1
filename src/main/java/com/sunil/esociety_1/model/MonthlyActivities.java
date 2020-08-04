package com.sunil.esociety_1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class MonthlyActivities {

    @Id
    private int id;
    private String activity_name;
    private double amount;
    private Timestamp created_at;
    private Date start_month;
    private Date end_month;
    private int manager_id;
    private int society_id;

    public MonthlyActivities(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Date getStart_month() {
        return start_month;
    }

    public void setStart_month(Date start_month) {
        this.start_month = start_month;
    }

    public Date getEnd_month() {
        return end_month;
    }

    public void setEnd_month(Date end_month) {
        this.end_month = end_month;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getSociety_id() {
        return society_id;
    }

    public void setSociety_id(int society_id) {
        this.society_id = society_id;
    }
}
