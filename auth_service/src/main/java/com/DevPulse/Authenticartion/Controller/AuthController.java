package com.DevPulse.Authenticartion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevPulse.Authenticartion.Dto.AuthRequest;
import com.DevPulse.Authenticartion.Dto.JwtResponse;
import com.DevPulse.Authenticartion.Dto.LoginDto;
import com.DevPulse.Authenticartion.Service.EmployeeService;
import com.DevPulse.Authenticartion.ServiceImpl.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService service;
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody AuthRequest request){
//		String token=service.login(lo.getEmail(),logindto.getPassword());
		
		 return ResponseEntity.ok(service.authenticate(request));
	}
}
