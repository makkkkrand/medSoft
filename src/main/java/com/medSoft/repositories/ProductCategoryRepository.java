package com.medSoft.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medSoft.models.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {

}
