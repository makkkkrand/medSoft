package com.medSoft.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.medSoft.models.ProductCategory;

@Service
public interface ProductCategoryService {

	String saveProductCategory(ProductCategory productCategory);
	List<ProductCategory> findAllProductCategory();
	ProductCategory findProductCategory(UUID id);
	String modifyProductCategory(ProductCategory productCategory, UUID id);
}
