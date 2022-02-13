package com.medSoft.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medSoft.models.ProductCategory;
import com.medSoft.repositories.ProductCategoryRepository;
import com.medSoft.services.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Autowired
	ProductCategoryRepository repo;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProductCategoryServiceImpl.class);
	
	@Override
	public String saveProductCategory(ProductCategory productCategory) {
		
		ProductCategory category = repo.save(productCategory);
		log.info("Saved productCategory:{}", category);
		return null != category ?"Pass":"Fail";
	}

	@Override
	public List<ProductCategory> findAllProductCategory() {
		return repo.findAll();
	}

	@Override
	public String modifyProductCategory(ProductCategory productCategory, UUID id) {
		productCategory.setId(id);
		ProductCategory category = repo.save(productCategory);
		log.info("Modified productCategory", category.getCategoryName());
		return null != category ?"Pass":"Fail";
	}

	@Override
	public ProductCategory findProductCategory(UUID id) {
		Optional<ProductCategory> category = repo.findById(id);
		log.info("Fetched productCategory", category.isPresent()?category.get():null);
		return category.isPresent()?category.get():null;
	}

}
