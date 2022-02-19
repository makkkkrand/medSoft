package com.medSoft.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "MANU_CONTACT")
@Data
public class ManufacturerContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public UUID code;

	@ManyToOne
	@JoinColumn(name = "id")
	private Manufacturer manufacturer;

	@Column(name = "contactType")
	private String contactType;
	@Column(name = "addressLine1")
	private String addressLine1;
	@Column(name = "addressLine2")
	private String addressLine2;
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "faxNo")
	private String faxNo;
	@Column(name = "email")
	private String email;
	@Column(name = "mobileNo")
	private String mobileNo;
	private final static long serialVersionUID = -9195452635953465778L;

}
