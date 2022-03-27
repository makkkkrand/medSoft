
package com.medSoft.app.models;

import java.io.Serializable;
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
@Table(name = "CUSTOMER")
@Data
public class CustomerSetup implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "deliveryRoute")
    private String deliveryRoute;
    @Column(name = "balanceSheetHeading")
    private String balanceSheetHeading;
    @Column(name = "contactPersonName")
    private String contactPersonName;
    
    @OneToMany(mappedBy = "CUSTOMER",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CustomerContactInfo> contactInfoSet;
    
    @Column(name = "category")
    private String category;
    @Column(name = "openingbalance")
    private String openingbalance;
    @Column(name = "creditOrDebit")
    private String creditOrDebit;
    @Column(name = "saleAccountName")
    private String saleAccountName;
    @Column(name = "godownName")
    private String godownName;
    @Column(name = "salesman")
    private Boolean salesman;
    @Column(name = "salesManName")
    private String salesManName;
    @Column(name = "commissionPercentage")
    private String commissionPercentage;
    @Column(name = "visitDay")
    private String visitDay;
    @Column(name = "deliveryMan")
    private String deliveryMan;
    @Column(name = "transportName")
    private String transportName;
    @Column(name = "transportionInvocePercent")
    private String transportionInvocePercent;
    @Column(name = "freight")
    private String freight;
    @Column(name = "terms")
    private Boolean terms;
    @Column(name = "lbtorOctproduct")
    private Boolean lbtorOctproduct;
    @Column(name = "lbtOrOctOnFreeQuantity")
    private Boolean lbtOrOctOnFreeQuantity;
    @Column(name = "wpOnExpiry")
    private Boolean wpOnExpiry;
    @Column(name = "noDiscountCustomer")
    private Boolean noDiscountCustomer;
    @Column(name = "noCashDiscountonExpiry")
    private Boolean noCashDiscountonExpiry;
    @Column(name = "scheme")
    private String scheme;
    @Column(name = "tradeMode")
    private String tradeMode;
    @Column(name = "salesPriceType")
    private String salesPriceType;
    @Column(name = "lockRateTypeInSale")
    private Boolean lockRateTypeInSale;
    @Column(name = "wp")
    private String wp;
    @Column(name = "octroi")
    private String octroi;
    @Column(name = "lbtorLocPercent")
    private String lbtorLocPercent;
    @Column(name = "td")
    private String td;
    @Column(name = "maxTd")
    private String maxTd;
    @Column(name = "cd")
    private String cd;
    @Column(name = "maxCd")
    private String maxCd;
    @Column(name = "tdorCdOnTurnover")
    private String tdorCdOnTurnover;
    @Column(name = "saleReturnAdjustmentOn")
    private String saleReturnAdjustmentOn;
    @Column(name = "srRates")
    private String srRates;
    @Column(name = "exRates")
    private String exRates;
    @Column(name = "returnInstructions")
    private String returnInstructions;
    @Column(name = "adjustSaleReturnInbetweenFrom")
    private String adjustSaleReturnInbetweenFrom;
    @Column(name = "adjustSaleReturnInbetweenTo")
    private String adjustSaleReturnInbetweenTo;
    @Column(name = "stopExpiryOrReturnAdjust")
    private String stopExpiryOrReturnAdjust;
    @Column(name = "payment")
    private Boolean payment;
    private final static long serialVersionUID = -9195452635953465778L;

}
