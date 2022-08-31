package com.medSoft.app.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
