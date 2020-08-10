package com.sunil.esociety_1.dao;

import com.sunil.esociety_1.model.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRoleDao extends JpaRepository<AuthRole,Integer> {

    public AuthRole findByRole(String role);
}
