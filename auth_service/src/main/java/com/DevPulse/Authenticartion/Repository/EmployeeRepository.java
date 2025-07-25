package com.DevPulse.Authenticartion.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevPulse.Authenticartion.Dto.EmployeeDto;
import com.DevPulse.Authenticartion.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

//	User getUser(long id);
	Optional<Employee> findByEmail(String email);


}
