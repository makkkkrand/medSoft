package com.medSoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medSoft.app.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {  } 