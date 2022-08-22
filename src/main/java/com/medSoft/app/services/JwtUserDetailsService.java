package com.medSoft.app.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.medSoft.app.models.User;

@Service
public interface JwtUserDetailsService extends UserDetailsService {

	public User save(User user);

}
