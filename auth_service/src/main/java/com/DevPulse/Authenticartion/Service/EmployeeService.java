package com.DevPulse.Authenticartion.Service;

import java.util.List;
import java.util.UUID;

import com.DevPulse.Authenticartion.Dto.EmployeeDto;
import com.DevPulse.Authenticartion.Entity.Employee;

//import org.springframework.stereotype.Service;


public interface EmployeeService {

//      User saveUser(UserDto userdto);
	 EmployeeDto getUser(long id);
	 EmployeeDto updateUser(long id,Employee user);
//	 void deleteUser(UUID id);
	 String loginUser(String email,String password);
	 void deleteUser(Long user_id);
	 EmployeeDto saveUser(EmployeeDto userdto);
	List<EmployeeDto> getAllUsers();
	Employee getEmployeeByEmail(String username);
}
