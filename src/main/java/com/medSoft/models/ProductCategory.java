package com.medSoft.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "medsoft_all", name = "PROD_CATEGORY")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID Id;
	
	@Column(name = "categoryName")
	private String categoryName;

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ProductCategory [Id=" + Id + ", categoryName=" + categoryName + "]";
	}
	
	
	
}
