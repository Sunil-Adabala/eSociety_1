package com.sunil.esociety_1.dao;

import com.sunil.esociety_1.model.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRoleDao extends JpaRepository<AuthRole,Integer> {

    public AuthRole findByRole(String role);

    @Query("SELECT role FROM AuthRole")
    List<String> getAllRoles();

    @Query("SELECT id FROM AuthRole WHERE role = :role")
    int getAuthRoleId(String role);
}
