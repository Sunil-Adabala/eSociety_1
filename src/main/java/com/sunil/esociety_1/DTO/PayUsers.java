package com.sunil.esociety_1.DTO;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;


import javax.persistence.Entity;

@Data
@NoArgsConstructor
@ToString
public class PayUsers {

    private String username;
    private int id;
    private double amount;
    private Date paid_at;
    private String email;


    public PayUsers(String username, int id, double amount) {
        this.username = username;
        this.id = id;
        this.amount = amount;
    }

    public PayUsers(String username, double amount, Date paid_at) {
        this.username = username;
        this.amount = amount;
        this.paid_at = paid_at;
    }

    public PayUsers(String username,int id,String email)
    {
        this.username = username;
        this.id = id;
        this.email = email;
    }

    //    public PayUsers(String username, int id) {
//        this.username = username;
//        this.id = id;
//        this.amount = amount;
//    }




}
