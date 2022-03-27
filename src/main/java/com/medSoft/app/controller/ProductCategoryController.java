package com.medSoft.app.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.medSoft.app.models.ProductCategory;
import com.medSoft.app.services.ProductCategoryService;


@Controller
public class ProductCategoryController {

	@Autowired
	ProductCategoryService productCategoryService;

	@RequestMapping(value = "productCategory/save", method = RequestMethod.POST)
	public String storeProductCategory(@RequestBody ProductCategory productCategory,
			@RequestHeader Map<String, String> header) {

		String saveProductCategory = productCategoryService.saveProductCategory(productCategory);
		return saveProductCategory;
	}

	@RequestMapping(value = "productCategory/fetchAll", method = RequestMethod.GET)
	public List<ProductCategory> fetchAllProductCategory() {
		List<ProductCategory> findAllProductCategory = productCategoryService.findAllProductCategory();
		return findAllProductCategory;
	}
	@RequestMapping(value = "productCategory/modify/{id}", method = RequestMethod.PUT)
	public String modifyProductCategory(@RequestBody ProductCategory productCategory, @PathVariable UUID id) {
		String modifyProductCategory = productCategoryService.modifyProductCategory(productCategory, id);
		return modifyProductCategory;
	}
	
	@RequestMapping(value = "productCategory/fetch/{id}", method = RequestMethod.GET)
	public ProductCategory fetchProductCategory(@PathVariable UUID id) {
		ProductCategory findProductCategory = productCategoryService.findProductCategory(id);
		return findProductCategory;
	}
	
}
