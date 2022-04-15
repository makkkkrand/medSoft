package com.medSoft.app.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.medSoft.app.models.UserDao;
import com.medSoft.app.models.LoginDto;

@Service
public interface JwtUserDetailsService extends UserDetailsService {

	public UserDao save(LoginDto user);

}
