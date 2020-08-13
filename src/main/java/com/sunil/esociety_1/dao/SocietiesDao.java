package com.sunil.esociety_1.dao;

import com.sunil.esociety_1.model.Societies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public interface SocietiesDao extends JpaRepository<Societies,Integer> {

    @Query("SELECT society_name FROM Societies ")
    List<String> getSocietyNames();

    @Query("SELECT id FROM Societies WHERE society_name = :society_name")
    int getSocietyId(String society_name);

}
