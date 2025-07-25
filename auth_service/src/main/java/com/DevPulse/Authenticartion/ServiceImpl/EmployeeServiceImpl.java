package com.DevPulse.Authenticartion.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.DevPulse.Authenticartion.Dto.EmployeeDto;
import com.DevPulse.Authenticartion.Entity.Employee;
import com.DevPulse.Authenticartion.Entity.Organisation;
import com.DevPulse.Authenticartion.Repository.EmployeeRepository;
import com.DevPulse.Authenticartion.Repository.OrganisationRepository;
import com.DevPulse.Authenticartion.Service.EmployeeService;
import com.DevPulse.Authenticartion.secuirity.JwtTokenProvider;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repo;
	@Autowired
	PasswordEncoder passwordEncoder;
//	@Autowired
//	JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	OrganisationRepository orgRepo;
	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> user=repo.findById(id);
		if(user.isPresent()) {
			repo.deleteById(id);
		}
		else {
			throw new RuntimeException(String.format("User Not Found with %d id", id));
		}
		
	}
//
//	@Override
//	public String loginUser(String email, String password) {
//		// TODO Auto-generated method stub
//		   Employee user = repo.findByEmail(email)
//	                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
//
//	        if (!passwordEncoder.matches(password, user.getPassword())) {
//	            throw new RuntimeException("Invalid credentials");
//	        }
//
//	        return jwtTokenProvider.generatetoken(user);
//	    }

	@Override
	public EmployeeDto saveUser(EmployeeDto empdto) {
		Organisation org=orgRepo.findById(empdto.getOrganisation().getOrganisation_id())
				.orElseThrow(()-> new RuntimeException("Organisation not found"));
		// TODO Auto-generated method stub
	    Employee employee = new Employee();
        employee.setUser_name(empdto.getUser_name());
        employee.setUser_email(empdto.getUser_email());
        employee.setPassword(passwordEncoder.encode(empdto.getPassword()));
        employee.setIsManager(empdto.getIsManager());
        employee.setProfilePhoto(empdto.getProfilePhoto());
        employee.setOrganisation(org);
        Employee  savedEmployee=repo.save(employee);
		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	



	

//	@Override
//	public User saveUser(User user) {
//		// TODO Auto-generated method stub
////		return null;	// TODO Auto-generated method stub
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		return repo.save(user);
//	}
	@Override
	public EmployeeDto updateUser(long id, Employee user) {
		// TODO Auto-generated method stub
		Optional<Employee> op=repo.findById(id);
		if(op.isPresent()) {
			Employee new_user=op.get();
		new_user.setUser_name(user.getUser_name());
		new_user.setUser_email(user.getUser_email());
		if(user.getPassword()!=null && !user.getPassword().isBlank()) {
			new_user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		Employee updatedUser=repo.save(new_user);
		return modelMapper.map(updatedUser, EmployeeDto.class);
		}else {
			throw new RuntimeException("User not found with ID: " + id);
		}
	}

@Override
public EmployeeDto getUser(long id) {
	// TODO Auto-generated method stub
//	return null;	
	Employee user=repo.findById(id).orElseThrow(
			()-> new RuntimeException(String.format("User not found with %d id",id))
		   ) ;
	return modelMapper.map(user,EmployeeDto.class);
}

@Override
public String loginUser(String email, String password) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<EmployeeDto> getAllUsers() {
	// TODO Auto-generated method stub
	return repo.findAll().stream()
            .map(EmployeeDto::new)
            .collect(Collectors.toList());
}

@Override
public Employee getEmployeeByEmail(String email) {
    return repo.findByEmail(email).orElseThrow(
    		()-> new UsernameNotFoundException(String.format("User not found with %s"+email))
    		);
}


//	@Override
//	public void deleteUser(UUID id) {
//		// TODO Auto-generated method stub
//		Optional<User> user=repo.findById(id);
//		if(user.isPresent()) {
//			repo.deleteById(id);
//		}
//		else {
//			throw new RuntimeException(String.format("User Not Found with %d id", id));
//		}
//		
//	}
//	

}
