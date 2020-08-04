package com.sunil.esociety_1.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Payments {

    @Id
    private int id;
    private int User_id;
    private Timestamp paid_at;
    private double amount;
    private boolean fine;
    private int manager_id;
    private int society_id;

//    @ManyToOne
//    private Users un;

    public Payments(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public Timestamp getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(Timestamp paid_at) {
        this.paid_at = paid_at;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isFine() {
        return fine;
    }

    public void setFine(boolean fine) {
        this.fine = fine;
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

//    public Users getUn() {
//        return un;
//    }
//
//    public void setUn(Users un) {
//        this.un = un;
//    }
}
