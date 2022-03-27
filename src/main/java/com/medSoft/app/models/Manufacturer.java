
package com.medSoft.app.models;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Manufacturer")
@Data
public class Manufacturer {

	private final static long serialVersionUID = 2352680475654840586L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@Column(name = "nickName")
	private String nickName;
	@Column(name = "balanceSheetHeader")
	private String balanceSheetHeader;
    @OneToMany(mappedBy = "Manufacturer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ManufacturerContactInfo> contactInfoSet;
	@Column(name = "medicalRepName")
	private String medicalRepName;
	@Column(name = "chequePayeeName")
	private String chequePayeeName;
	@Column(name = "purchaseLockin")
	private Boolean purchaseLockin;
	@Column(name = "lockSales")
	private Boolean lockSales;
	@Column(name = "lockPurchaseOrder")
	private Boolean lockPurchaseOrder;
	@Column(name = "daystoLockPayorderToMedrep")
	private Integer daystoLockPayorderToMedrep;
	@Column(name = "purchaseReturnWithMaxMRP")
	private Boolean purchaseReturnWithMaxMRP;
	@Column(name = "saleCalulation")
	private String saleCalulation;
	@Column(name = "wp")
	private String wp;
	@Column(name = "td")
	private String td;
	@Column(name = "cd")
	private String cd;
	@Column(name = "creditdays")
	private String creditdays;
	@Column(name = "creditNotesExpiry")
	private String creditNotesExpiry;
	@Column(name = "salableRateType")
	private String salableRateType;
	@Column(name = "debitNoteClearInDays")
	private String debitNoteClearInDays;
	@Column(name = "localVatTinNo")
	private String localVatTinNo;
	@Column(name = "localVatTinRegDate")
	private String localVatTinRegDate;
	@Column(name = "centralVatTinNo")
	private String centralVatTinNo;
	@Column(name = "centralVatTinRegDate")
	private String centralVatTinRegDate;
	@Column(name = "taxComputedOn")
	private String taxComputedOn;
	@Column(name = "panNo")
	private String panNo;
	@Column(name = "tanNo")
	private String tanNo;
	@Column(name = "drugLicenseNo")
	private String drugLicenseNo;
	@Column(name = "drugLicenseValidUpto")
	private String drugLicenseValidUpto;
	@Column(name = "lbtCessNo")
	private String lbtCessNo;
	@Column(name = "localImported")
	private String localImported;
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "creationDate")
	private String creationDate;
	@Column(name = "modificationDate")
	private String modificationDate;

}
