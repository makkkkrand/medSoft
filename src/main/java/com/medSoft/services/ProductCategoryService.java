package com.medSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medSoft.models.ProductCategory;

@Service
public interface ProductCategoryService {

	String saveProductCategory(ProductCategory productCategory);
	List<ProductCategory> findAllProductCategory();
	String modifyProductCategory(ProductCategory productCategory, long id);
}
