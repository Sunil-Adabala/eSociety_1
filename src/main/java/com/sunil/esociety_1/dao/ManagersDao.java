//package com.sunil.esociety_1.dao;
//
//import com.sunil.esociety_1.model.Managers;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface ManagersDao extends JpaRepository<Managers,Integer>
//{
//
//    @Query("SELECT manager_name FROM Managers")
//    List<String> getMangerNames();
//
//    @Query("SELECT id FROM Managers WHERE manager_name = :manager_name")
//    int getMangerId(String manager_name);
//}
