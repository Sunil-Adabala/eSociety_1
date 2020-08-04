package com.sunil.esociety_1.dao;

import com.sunil.esociety_1.model.MonthlyActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonthlyActivitiesDao extends JpaRepository<MonthlyActivities,Integer> {

    @Query("SELECT SUM(amount) AS month_price FROM MonthlyActivities where society_id = :society_id")
    double getMonthAmount(Integer society_id);

}
