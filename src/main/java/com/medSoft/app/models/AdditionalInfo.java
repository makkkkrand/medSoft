package com.medSoft.app.models;

import jakarta.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mukundkumarjha
 *
 *	this class will be used for future advancement in code
 *
 */
@Data
@EqualsAndHashCode
public class AdditionalInfo extends Base{
	private static final long serialVersionUID = 1L;
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