package com.DevPulse.Authenticartion.secuirity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.DevPulse.Authenticartion.Entity.Employee;
import com.DevPulse.Authenticartion.Repository.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	EmployeeRepository repo;
	

		// TODO Auto-generated method stub
	
		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
			Employee user=repo.findByEmail(email).orElseThrow(
					()-> new UsernameNotFoundException(String.format("User not found"+email))
					);
			  return User.builder()
			            .username(user.getUser_email())
			            .password(user.getPassword())
			            .roles("USER")  // or fetch from DB
			            .build();
		}

	
	
}
