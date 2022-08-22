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

import com.medSoft.app.models.ProductCategory;
import com.medSoft.app.services.ProductCategoryService;


@RestController
//@SecurityRequirement(name = "medSoftApi")
public class ProductCategoryController {

	@Autowired
	ProductCategoryService productCategoryService;

	@PostMapping(value = "/productCategory/save")
	public String storeProductCategory(@RequestBody ProductCategory productCategory,
			@RequestHeader Map<String, String> header) {

		String saveProductCategory = productCategoryService.saveProductCategory(productCategory);
		return saveProductCategory;
	}

	@GetMapping(value = "/productCategory/fetchAll")
	public List<ProductCategory> fetchAllProductCategory() {
		List<ProductCategory> findAllProductCategory = productCategoryService.findAllProductCategory();
		return findAllProductCategory;
	}
	@PutMapping(value = "/productCategory/modify/{id}")
	public String modifyProductCategory(@RequestBody ProductCategory productCategory, @PathVariable UUID id) {
		String modifyProductCategory = productCategoryService.modifyProductCategory(productCategory, id);
		return modifyProductCategory;
	}
	
	@GetMapping(value = "/productCategory/fetch/{id}")
	public ProductCategory fetchProductCategory(@PathVariable UUID id) {
		ProductCategory findProductCategory = productCategoryService.findProductCategory(id);
		return findProductCategory;
	}
	
}
