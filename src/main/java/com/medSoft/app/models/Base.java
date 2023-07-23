package com.medSoft.app.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Base implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column
	private String creationBy;
	@Column
	private String modifiedBy;
	@Column
	private Date creationDate;
	@Column
	private Date modifiedDate;
}
