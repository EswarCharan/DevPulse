package com.DevPulse.Authenticartion.Dto;

import com.DevPulse.Authenticartion.Entity.Employee;

//import java.util.UUID;

import com.DevPulse.Authenticartion.Entity.Organisation;





public class EmployeeDto {

	
	private long user_id;
	private String user_name;
	private String first_name;
	private String last_name;
	private String user_email;
	private String password;
private Boolean is_manager;
	

	private String profilePhoto;
	private Organisation organisation;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Organisation getOrganisation() {
		return organisation;
	}
	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}
	public Boolean getIsManager() {
		return is_manager;
	}
	public void setIsManager(Boolean isManager) {
		this.is_manager = isManager;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public EmployeeDto(long user_id, String user_name, String user_email, String password, Boolean isManager,
			String profilePhoto, Organisation organisation) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.password = password;
		this.is_manager = isManager;
		this.profilePhoto = profilePhoto;
		this.organisation = organisation;
	}
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDto(long user_id, String user_name, String user_email) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
	}
	public EmployeeDto(Employee employee) {
	    this.user_id = employee.getUser_id();
	    this.user_name = employee.getUser_name();
	    this.user_email = employee.getUser_email();
	    this.password = employee.getPassword();
	    this.is_manager = employee.getIsManager();
	    this.profilePhoto = employee.getProfilePhoto();
	    this.organisation = employee.getOrganisation(); // assuming deep copy isn't required
	}
	
	
}
