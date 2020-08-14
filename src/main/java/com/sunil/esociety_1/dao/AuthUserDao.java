package com.sunil.esociety_1.dao;

import com.sunil.esociety_1.model.AuthUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AuthUserDao extends JpaRepository<AuthUserRole,Integer> {
}
