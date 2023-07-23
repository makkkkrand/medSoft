package com.medSoft.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companyDetails")
public class Company extends AdditionalInfo {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "IntegerIdGenerator", strategy = "com.medSoft.util.IdGenerator")
	@GeneratedValue(generator = "IntegerIdGenerator")
	@Column(name="companyId")
	private int id;
	
	@Column(name="companyName")
	private String name;
	
	@Embedded
	private Address address;
	
	@Column
	private String gstNumber;
	
	@Column
	private String telephoneNumber;
	
	@Column
	private String mobileNumber;

	@Column
	private String panNumber;

	@Column
	private String ownerName;
	
	@Column
	private String ownerContactInfo;
	
	@Column
	private String ownerPanNumber;
	
	@Column
	private boolean enabled;
	
}
