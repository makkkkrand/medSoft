package com.medSoft.app.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companyDetails")
public class Company {
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
	
	@Nullable
	@Embedded
	private AdditionalInfo additionalInfo;
	
	@Embedded
	private Base base;

}
