package com.medSoft.app.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mukundkumarjha
 *
 *	this class will be used for future advancement in code
 *
 */
@Data
@Embeddable
@EqualsAndHashCode
public class AdditionalInfo {
	@Column
	public String additionalInfo1;
	@Column
	public String additionalInfo2;
	@Column
	public String additionalInfo3;
	@Column
	public String additionalInfo4;
	@Column
	public String additionalInfo5;
	@Column
	public String additionalInfo6;
	@Column
	public String additionalInfo7;
	@Column
	public String additionalInfo8;

}