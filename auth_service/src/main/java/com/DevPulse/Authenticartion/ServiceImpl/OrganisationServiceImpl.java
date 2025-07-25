package com.DevPulse.Authenticartion.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevPulse.Authenticartion.Entity.Organisation;
import com.DevPulse.Authenticartion.Repository.OrganisationRepository;
import com.DevPulse.Authenticartion.Service.OrganisationService;

@Service
public class OrganisationServiceImpl implements OrganisationService {

	@Autowired
	OrganisationRepository orgRepo;
	@Override
	public Organisation createOrg(Organisation org) {
		// TODO Auto-generated method stub
		return orgRepo.save(org);
	}

	@Override
	public List<Organisation> getAllOrgs() {
		// TODO Auto-generated method stub
		return orgRepo.findAll();
	}
	
	public Optional<Organisation> getOrgByEmail(String email) {
		return orgRepo.findByEmail(email);
	}

	
}
