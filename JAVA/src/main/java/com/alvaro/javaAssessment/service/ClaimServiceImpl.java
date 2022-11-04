package com.alvaro.javaAssessment.service;

import com.alvaro.javaAssessment.model.Claim;
import com.alvaro.javaAssessment.repository.ClaimRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    ClaimRepository claimRepository;

    @Override
    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public Optional<Claim> getClaim(Integer id) {
        return claimRepository.findById(id);
    }

    @Override
    public void updateClaim(Integer id, Claim claim) {
        Optional<Claim> claimOptional = claimRepository.findById(id);
        if (!claimOptional.isPresent()) {
            claim.setId(id);
            claimRepository.save(claim);
        } else {
            Claim claimFound = claimOptional.get();
            claimFound.setDescription(claim.getDescription());
            claimFound.setStatus(claim.getStatus());
            claimRepository.save(claimFound);
        }
    }

    @Override
    public void deleteClaim(Integer id) {
        claimRepository.deleteById(id);
    }
}
