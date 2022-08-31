package com.medSoft.app.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medSoft.app.models.Company;
import com.medSoft.app.repositories.CompanyRepository;
import com.medSoft.app.services.CompanyService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository repo;

	@Override
	public String saveCompany(Company Company) {
		Company output = repo.save(Company);
		log.info("Saved Company:{}", output);
		return null != output ? "Pass" : "Fail";
	}

	@Override
	public List<Company> findAllCompany() {
		return repo.findAll();
	}

	@Override
	public String modifyCompany(Company Company, int id) {
		Company.setId(id);
		Company output = repo.save(Company);
		log.info("Modified Company", output.getId());
		return null != output ? "Pass" : "Fail";
	}

	@Override
	public Company findCompany(int id) {
		Optional<Company> output = repo.findById(id);
		log.info("Fetched Company", output.isPresent() ? output.get() : null);
		return output.isPresent() ? output.get() : null;
	}
}