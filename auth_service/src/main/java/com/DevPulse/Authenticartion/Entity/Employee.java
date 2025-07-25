package com.DevPulse.Authenticartion.Entity;

import java.util.UUID;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="users")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long user_id;
	@Column(unique=true ,nullable=false)
	private String username;
	private String first_name;
	private String last_name;
	@Column(name="user_email" ,nullable=false,unique=true)
	private String email;
	private String password;
	private Boolean is_manager;
	

	private String profilePhoto;

	@ManyToOne
	@JoinColumn(name="organisation_id")
	private Organisation organisation;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return username;
	}

	public void setUser_name(String user_name) {
		this.username = user_name;
	}

	public String getUser_email() {
		return email;
	}

	public void setUser_email(String user_email) {
		this.email = user_email;
	}
	public Organisation getOrganisation() {
	    return organisation;
	}

	public void setOrganisation(Organisation organisation) {
	    this.organisation = organisation;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Employee(long user_id, String username, String first_name, String last_name, String email, String password,
			Boolean is_manager, String profilePhoto, Organisation organisation) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.is_manager = is_manager;
		this.profilePhoto = profilePhoto;
		this.organisation = organisation;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
