package com.alvaro.javaAssessment.controller;

import com.alvaro.javaAssessment.model.Owner;
import com.alvaro.javaAssessment.repository.OwnerRepository;
import com.alvaro.javaAssessment.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owner")
@CrossOrigin
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping()
    public ResponseEntity<String> addOwner(@RequestBody Owner owner){
        ownerService.saveOwner(owner);
        return ResponseEntity.status(HttpStatus.OK).body("User: " + owner.getFirstName() +" added");
    }

    @GetMapping()
    public List<Owner> getAllOwners(){
        return ownerService.getAllOwners();
    }

    @GetMapping("{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Integer id){
        Optional<Owner> owner = ownerService.getOwner(id);
        if(owner.isPresent())
            return ResponseEntity.status((HttpStatus.OK)).body(owner.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @PutMapping("{id}")
    public void updateOwner(@PathVariable Integer id, @RequestBody Owner owner) {
        ownerService.updateOwner(id,owner);
    }

    @DeleteMapping("{id}")
    public void deleteOwner(@PathVariable Integer id) {
        ownerService.deleteOwner(id);
    }
}
