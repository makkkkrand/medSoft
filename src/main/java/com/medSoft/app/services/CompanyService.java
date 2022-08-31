package com.medSoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medSoft.app.models.Company;

@Service
public interface CompanyService {
	String saveCompany(Company Company);

	List<Company> findAllCompany();

	Company findCompany(int id);

	String modifyCompany(Company Company, int id);
}