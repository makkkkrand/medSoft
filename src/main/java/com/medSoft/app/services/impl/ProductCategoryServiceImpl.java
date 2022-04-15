package com.medSoft.app.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medSoft.app.models.ProductCategory;
import com.medSoft.app.repositories.ProductCategoryRepository;
import com.medSoft.app.services.ProductCategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Autowired
	ProductCategoryRepository repo;

	@Override
	public String saveProductCategory(ProductCategory productCategory) {
		
		ProductCategory output = repo.save(productCategory);
		log.info("Saved productCategory:{}", output);
		return null != output ?"Pass":"Fail";
	}

	@Override
	public List<ProductCategory> findAllProductCategory() {
		return repo.findAll();
	}

	@Override
	public String modifyProductCategory(ProductCategory productCategory, UUID id) {
		productCategory.setId(id);
		ProductCategory output = repo.save(productCategory);
		log.info("Modified productCategory", output.getCategoryName());
		return null != output ?"Pass":"Fail";
	}

	@Override
	public ProductCategory findProductCategory(UUID id) {
		Optional<ProductCategory> output = repo.findById(id);
		log.info("Fetched productCategory", output.isPresent()?output.get():null);
		return output.isPresent()?output.get():null;
	}

}
