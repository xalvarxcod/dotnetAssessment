package com.alvaro.javaAssessment.service;

import com.alvaro.javaAssessment.model.Claim;

import java.util.List;
import java.util.Optional;

public interface ClaimService {
    public Claim saveClaim(Claim claim);
    public List<Claim> getAllClaims();
    public Optional<Claim> getClaim(Integer id);
    public void updateClaim(Integer id, Claim claim);
    public void deleteClaim(Integer id);
}
