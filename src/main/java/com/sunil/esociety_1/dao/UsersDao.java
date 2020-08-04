package com.sunil.esociety_1.dao;

import com.sunil.esociety_1.DTO.PayUsers;

import com.sunil.esociety_1.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface UsersDao extends JpaRepository<Users,Integer> {
//        @Query("SELECT new com.sunil.esociety_1.DTO.PayUsers(Users.username) FROM Users JOIN Payments" )
//        List<PayUsers> getInfo(Integer id);

    //change if any error autorwiring


    @Query("SELECT new com.sunil.esociety_1.DTO.PayUsers(c.username,c.id,p.amount) FROM Users c JOIN c.payments p WHERE c.id = :id" )
    List<PayUsers> getInfo(Integer id);

    @Query("SELECT new com.sunil.esociety_1.DTO.PayUsers(c.username,p.amount,p.paid_at) FROM Users c JOIN c.payments p ON c.id = p.User_id AND YEAR(paid_at) = :yr" )
    List<PayUsers> getYearReport(Integer yr);

    @Query("SELECT new com.sunil.esociety_1.DTO.PayUsers(c.username) FROM Users c JOIN c.payments p ON c.id = p.User_id AND p.paid_at > :from and p.paid_at < :to and p.paid_at IS NULL")
    List<PayUsers> getUnpaid(Date from, Date to);

    @Query("SELECT COUNT(society_id) as total_members FROM Users where society_id = :society_id")
    int getTotalmembers(int society_id);

    Users findByUsername(String username);

//        @Query(value = "SELECT * FROM users",nativeQuery = true)
//        List<Users> findPaymentsById();
}
