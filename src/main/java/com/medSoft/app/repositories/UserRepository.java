package com.medSoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medSoft.app.models.UserDao;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Integer> {
	
	UserDao findByUsername(String username);
	
}