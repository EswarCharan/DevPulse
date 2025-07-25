package com.DevPulse.Authenticartion.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevPulse.Authenticartion.Entity.Organisation;
import com.DevPulse.Authenticartion.Entity.Employee;

public interface OrganisationRepository extends JpaRepository<Organisation,UUID> {

	Optional<Organisation> findByEmail(String email);
	
}
