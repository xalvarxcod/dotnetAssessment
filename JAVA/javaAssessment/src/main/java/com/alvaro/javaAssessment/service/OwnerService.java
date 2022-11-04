package com.alvaro.javaAssessment.service;

import com.alvaro.javaAssessment.model.Claim;
import com.alvaro.javaAssessment.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
    public Owner saveOwner(Owner owner);
    public List<Owner> getAllOwners();
    public Optional<Owner> getOwner(Integer id);
    public void updateOwner(Integer id, Owner owner);
    public void deleteOwner(Integer id);
}
