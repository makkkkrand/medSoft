package com.medSoft.app.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.medSoft.app.models.Company;
import com.medSoft.app.services.CompanyService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "medSoftApi")
public class CompanyController {
	@Autowired
	CompanyService CompanyService;

	@PostMapping(value = "/Company/save")
	public String storeCompany(@RequestBody Company Company, @RequestHeader Map<String, String> header) {
		String saveCompany = CompanyService.saveCompany(Company);
		return saveCompany;
	}

	@GetMapping(value = "/Company/fetchAll")
	public List<Company> fetchAllCompany() {
		List<Company> findAllCompany = CompanyService.findAllCompany();
		return findAllCompany;
	}

	@PutMapping(value = "/Company/modify/{id}")
	public String modifyCompany(@RequestBody Company Company, @PathVariable int id) {
		String modifyCompany = CompanyService.modifyCompany(Company, id);
		return modifyCompany;
	}

	@GetMapping(value = "/Company/fetch/{id}")
	public Company fetchCompany(@PathVariable int id) {
		Company findCompany = CompanyService.findCompany(id);
		return findCompany;
	}
}