package com.medSoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medSoft.app.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
