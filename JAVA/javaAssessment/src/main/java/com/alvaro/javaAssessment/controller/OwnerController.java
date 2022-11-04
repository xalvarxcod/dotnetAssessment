package com.alvaro.javaAssessment.controller;

import com.alvaro.javaAssessment.repository.OwnerRepository;
import com.alvaro.javaAssessment.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.acl.Owner;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class OwnerController {
    @Autowired
    private OwnerRepository ownerRepository;

    @PostMapping()
    public ResponseEntity<String> addUser(@RequestBody Owner owner){
        ownerRepository.savePerson(owner);
        return ResponseEntity.status(HttpStatus.OK).body("User: " + owner.+" added");
    }

    @GetMapping()
    public List<Owner> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping("{id}")
    public ResponseEntity<Owner> getUser(@PathVariable Integer id){
        Optional<Owner> person = personService.getPerson(id);
        if(person.isPresent())
            return ResponseEntity.status((HttpStatus.OK)).body(person.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
