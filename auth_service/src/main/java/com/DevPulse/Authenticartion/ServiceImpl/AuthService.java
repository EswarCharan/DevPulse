package com.DevPulse.Authenticartion.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.DevPulse.Authenticartion.Dto.AuthRequest;
import com.DevPulse.Authenticartion.Dto.JwtResponse;
import com.DevPulse.Authenticartion.Entity.Employee;
import com.DevPulse.Authenticartion.Repository.EmployeeRepository;
import com.DevPulse.Authenticartion.secuirity.JwtTokenProvider;

@Service
public class AuthService {

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	EmployeeRepository repo;
	
	 public JwtResponse authenticate(AuthRequest request) {
	        Authentication auth = authManager.authenticate(
	            new UsernamePasswordAuthenticationToken(request.username, request.password)
	        );

	        Employee user = repo.findByEmail(request.username)
	            .orElseThrow();

	        String token = jwtTokenProvider.generatetoken((UserDetails) auth.getPrincipal());
	        return new JwtResponse(token, user.getUser_email(), user.getOrganisation().getOrganisation_id());
	     }
}
