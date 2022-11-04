package com.alvaro.javaAssessment.service;

import com.alvaro.javaAssessment.model.Owner;
import com.alvaro.javaAssessment.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> getOwner(Integer id) {
        return ownerRepository.findById(id);
    }

    @Override
    public void updateOwner(Integer id, Owner owner) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        if (!ownerOptional.isPresent()) {
            owner.setId(id);
            ownerRepository.save(owner);
        } else {
            Owner ownerFound = ownerOptional.get();
            ownerFound.setDriverLicense(owner.getDriverLicense());
            ownerFound.setFirstName(owner.getFirstName());
            ownerFound.setLastName(owner.getLastName());
            ownerRepository.save(ownerFound);
        }
    }

    @Override
    public void deleteOwner(Integer id) {
        ownerRepository.deleteById(id);
    }
}
