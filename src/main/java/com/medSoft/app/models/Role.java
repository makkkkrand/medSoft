package com.medSoft.app.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	
	@Id
	@Column(name = "UserRoleId")
	private int UserRoleId;
	@Column
	private String role;
	@Embedded
	private Base base;
	
}
