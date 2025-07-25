package com.DevPulse.Authenticartion.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="organizations")
public class Organisation {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private UUID organisation_id;
	private String name;
	@Column(nullable=false)
	private String email;
	private String description;
	public UUID getOrganisation_id() {
		return organisation_id;
	}
	public void setOrganisation_id(UUID organisation_id) {
		this.organisation_id = organisation_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Organisation(UUID organisation_id, String name, String email, String description) {
		super();
		this.organisation_id = organisation_id;
		this.name = name;
		this.email = email;
		this.description = description;
	}
	public Organisation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
