package com.DevPulse.Authenticartion.Dto;

import java.util.UUID;

public class JwtResponse {


	public String token;
    public String username;
    public UUID organisationId;

    public JwtResponse(String token, String username, UUID organisationId) {
        this.token = token;
        this.username = username;
        this.organisationId = organisationId;
    }
}
