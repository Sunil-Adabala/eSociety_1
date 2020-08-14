package com.sunil.esociety_1.dao;

import com.sunil.esociety_1.DTO.PayUsers;

import com.sunil.esociety_1.model.AuthRole;
import com.sunil.esociety_1.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface UsersDao extends JpaRepository<Users,Integer> {
//        @Query("SELECT new com.sunil.esociety_1.DTO.PayUsers(Users.username) FROM Users JOIN Payments" )
//        List<PayUsers> getInfo(Integer id);

    //change if any error autorwiring


    @Query("SELECT new com.sunil.esociety_1.DTO.PayUsers(c.username,c.id,p.amount) FROM Users c JOIN c.payments p WHERE c.id = :id" )
    List<PayUsers> getInfo(Integer id);

    @Query("SELECT new com.sunil.esociety_1.DTO.PayUsers(c.username,p.amount,p.paid_at) FROM Users c JOIN c.payments p ON c.id = p.User_id AND YEAR(paid_at) = :yr AND p.society_id = :society_id" )
    List<PayUsers> getYearReport(Integer yr,Integer society_id);

    @Query("SELECT new com.sunil.esociety_1.DTO.PayUsers(c.username,c.id,c.email) FROM Users c LEFT JOIN c.payments p ON c.id = p.User_id AND p.paid_at > :from and p.paid_at < :to and p.paid_at IS NULL")
    List<PayUsers> getUnpaid(Date from, Date to);

    @Query("SELECT username FROM Users")
    List<String> getAllUsers();


    @Query("SELECT COUNT(society_id) as total_members FROM Users where society_id = :society_id")
    int getTotalmembers(int society_id);



    Users findByUsername(String username);
//    SELECT u FROM User u WHERE u.username = :username
    @Query("SELECT u FROM Users u WHERE u.username = :username")
    Users getUserByUsername(@Param("username") String username);

    @Query("SELECT society_id FROM Users where username = :username")
    int getSocietyId(String username);

    @Query("SELECT id FROM Users where username = :username")
    int getUserId(String username);

    @Query("SELECT manager_id FROM Users where username= :username")
    int getManagerId(String username);



//    @Query("SELECT id,username,email,created_at,society_id FROM Users where username = :username")
//    List<Users> getCurrentUserDetails(String username);
//
    List<Users> findAllByUsername(String username);

    //for email sending
    @Query("SELECT email from Users")
    List<String> getEmailOfAllusers();


//        @Query(value = "SELECT * FROM users",nativeQuery = true)
//        List<Users> findPaymentsById();
}
