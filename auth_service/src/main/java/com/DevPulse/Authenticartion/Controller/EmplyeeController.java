package com.DevPulse.Authenticartion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevPulse.Authenticartion.Dto.EmployeeDto;
import com.DevPulse.Authenticartion.Entity.Employee;
import com.DevPulse.Authenticartion.Service.EmployeeService;

@RestController
@RequestMapping("/user")
public class EmplyeeController {
	@Autowired
	 private EmployeeService service;

	@PostMapping("/register")
	public ResponseEntity<EmployeeDto> createUser(@RequestBody EmployeeDto userDto){
		return new ResponseEntity<>(service.saveUser(userDto),HttpStatus.OK);
	}
	   @GetMapping("/{id}/users")
	    public ResponseEntity<EmployeeDto> getUser(@PathVariable long id) {
	        return ResponseEntity.ok(service.getUser(id));
	    }
	   @PutMapping("/{id}/update")
	    public ResponseEntity<EmployeeDto> updateUser(@PathVariable long id, @RequestBody Employee user) {
	        return ResponseEntity.ok(service.updateUser(id, user));
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
	        service.deleteUser(id);
	        return ResponseEntity.noContent().build();
	    }
	    @GetMapping("/getAll")
	    public ResponseEntity<List<EmployeeDto>> getAll() {
	        return ResponseEntity.ok(service.getAllUsers());
	    }
}
