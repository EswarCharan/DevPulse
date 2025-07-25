package com.DevPulse.Authenticartion.secuirity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.DevPulse.Authenticartion.Entity.Employee;
import com.DevPulse.Authenticartion.Entity.Organisation;
import com.DevPulse.Authenticartion.Service.EmployeeService;
import com.DevPulse.Authenticartion.Service.OrganisationService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

	@Autowired
	private EmployeeService emp;
//	@Autowired
//	private OrganisationService org;
	
	
	private final String  secret_key="xn1GibkhV0asnOYSYCMwVmO1eELHktdYUeUbjrmLKic=";
	
	public String generatetoken(UserDetails user) {
		 Employee employee = emp.getEmployeeByEmail(user.getUsername());
		 Organisation organisation=employee.getOrganisation();
		Date currDate=new Date();
		Date expiredDate= new Date(currDate.getTime()+3600000*24*365);
//		String role=employee.getIsManager()?"manager":"employee";
		return Jwts.builder()
				.claim("user_id",employee.getUser_id())
				.claim("user_role",employee.getIsManager()?"manager":"employee")
				.claim("org_id", organisation.getOrganisation_id())
//				.claim("org_id",org.getOrganisation_id())
				.setIssuedAt(currDate)
				.setExpiration(expiredDate)
				.signWith(SignatureAlgorithm.HS256,secret_key)
				.compact();
	}
	   public String getEmailFromToken(String token) {
	        Claims claims = Jwts.parserBuilder()
	            .setSigningKey(secret_key)
	            .build()
	            .parseClaimsJws(token)
	            .getBody();

	        return claims.getSubject();
	    }
	   public boolean validateToken(String token,UserDetails user) {
		   return getEmailFromToken(token).equals(user.getUsername());
	   }
}
