package com.medSoft.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.medSoft.models.ProductCategory;
import com.medSoft.services.ProductCategoryService;


@RestController
public class ProductCategoryController {

	@Autowired
	ProductCategoryService productCategoryService;

	@PostMapping(path = "productCategory/save")
	public String storeProductCategory(@RequestBody ProductCategory productCategory,
			@RequestHeader Map<String, String> header) {

		String saveProductCategory = productCategoryService.saveProductCategory(productCategory);
		return saveProductCategory;
	}

	@GetMapping(path = "productCategory/fetchAll")
	public List fetchAllProductCategory() {
		List<ProductCategory> findAllProductCategory = productCategoryService.findAllProductCategory();
		return findAllProductCategory;
	}

	@PutMapping(path = "productCategory/modify/{id}")
	public String modifyProductCategory(@RequestBody ProductCategory productCategory, @PathVariable long id) {
		String modifyProductCategory = productCategoryService.modifyProductCategory(productCategory, id);
		return modifyProductCategory;
	}
	
	@GetMapping(path = "productCategory/fetch/{id}")
	public ProductCategory fetchProductCategory(@PathVariable long id) {
		ProductCategory findProductCategory = productCategoryService.findProductCategory(id);
		return findProductCategory;
	}
	
}
