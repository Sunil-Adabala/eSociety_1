package com.sunil.esociety_1.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Users {

    @Id
    private int id;
    private String username;
    @Column(name = "pass")
    private String password;
    private String email;
    private Timestamp created_at;
    private int society_id;

//    @OneToMany(mappedBy = "un")
//    private List<Payments> pm = new ArrayList<Payments>();

    @OneToMany(targetEntity = Payments.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id",referencedColumnName = "id")
    private List<Payments> payments;

//
//    public Users() {
//    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Timestamp getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(Timestamp created_at) {
//        this.created_at = created_at;
//    }
//
//    public int getSociety_id() {
//        return society_id;
//    }
//
//    public void setSociety_id(int society_id) {
//        this.society_id = society_id;
//    }


}





