package com.medSoft.app.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PROD_CATEGORY")
@Data
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID Id;
	@Column(name = "categoryName")
	private String categoryName;
	@Embedded
	private Base base;

}
