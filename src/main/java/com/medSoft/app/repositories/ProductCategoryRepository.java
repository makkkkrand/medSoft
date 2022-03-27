package com.medSoft.app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medSoft.app.models.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {

}
