package com.sunil.esociety_1.dao;

import com.sunil.esociety_1.DTO.PayUsers;
import com.sunil.esociety_1.model.Payments;
import com.sunil.esociety_1.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentsDao extends JpaRepository<Payments,Integer> {
//    @Query("SELECT YEAR(paid_at) FROM Payments WHERE YEAR(paid_at) = :yr")
//    List<Integer> getYearReports(Integer yr);

    @Query("SELECT sum(amount) FROM Payments where Month(paid_at) = :month and user_id = :id")
    Double getPaidAmount(Integer id,Integer month);


}
