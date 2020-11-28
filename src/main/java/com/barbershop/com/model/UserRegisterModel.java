package com.barbershop.com.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "USER_REGISTER")
@Entity
public class UserRegisterModel implements Serializable, UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Lob
	private byte[] photo;

	private String fullName;

	private String age;

	private String phone;

	@Column(unique = true)
	private String email;

	private String password;

	private String role;
	
	private Boolean enable;
	
	
	// UserDetails methods

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}
	

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return email;
	}
	
	

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
		
}