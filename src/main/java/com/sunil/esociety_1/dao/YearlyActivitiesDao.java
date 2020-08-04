package com.sunil.esociety_1.dao;

import com.sunil.esociety_1.model.YearlyActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface YearlyActivitiesDao extends JpaRepository<YearlyActivities,Integer> {

//    @Query("SELECT SUM(amount) AS month_price FROM MonthlyActivities where society_id = :society_id")
//    double getamount(Integer society_id);
    @Query("SELECT SUM(amount) AS year_price FROM YearlyActivities where society_id = :society_id")
    double getYearAmount(Integer society_id);

}
