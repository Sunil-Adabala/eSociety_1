package com.sunil.esociety_1.dao;

import com.sunil.esociety_1.model.Societies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocietiesDao extends JpaRepository<Societies,Integer> {
}
