package com.medSoft.app.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userdetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements UserDetails {

	private static final long serialVersionUID = 7946657849577891456L;
	@Id
	@Column(name = "user_id")
	private UUID id;
	@Column
	private String username;
	@Column
	private String password;

	@OneToOne
	@JoinColumn(name = "companyId", nullable = false)
	private Company company;

	@Column
	private boolean accountNonExpired;

	@Column
	private boolean accountNonLocked;

	@Column
	private boolean credentialsNonExpired;

	@Column
	private boolean enabled;

	@Column
	@OneToOne(mappedBy = "UserRoleId")
	private Role role;

	public User(boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		super();
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(role.getRole()));
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		this.accountNonExpired = true;
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		this.accountNonLocked = true;
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		this.credentialsNonExpired = true;
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		this.enabled = true;
		return this.enabled;
	}

}