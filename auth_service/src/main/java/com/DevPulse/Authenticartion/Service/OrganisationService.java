package com.DevPulse.Authenticartion.Service;

import java.util.List;
import java.util.Optional;

import com.DevPulse.Authenticartion.Entity.Organisation;

public interface OrganisationService {

	Organisation createOrg(Organisation org);
    List<Organisation> getAllOrgs();
    Optional<Organisation> getOrgByEmail(String email);
}
