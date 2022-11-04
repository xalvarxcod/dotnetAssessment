package com.alvaro.javaAssessment.controller;

import com.alvaro.javaAssessment.model.Claim;
import com.alvaro.javaAssessment.model.Owner;
import com.alvaro.javaAssessment.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/claim")
@CrossOrigin
public class ClaimController {
    @Autowired
    private ClaimService claimService;

    @PostMapping()
    public ResponseEntity<String> addClaim(@RequestBody Claim claim) {
        claimService.saveClaim(claim);
        return ResponseEntity.status(HttpStatus.OK).body("User: " + claim.getDescription() + " added");
    }

    @GetMapping()
    public List<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("{id}")
    public ResponseEntity<Claim> getOwner(@PathVariable Integer id) {
        Optional<Claim> claim = claimService.getClaim(id);
        if (claim.isPresent())
            return ResponseEntity.status((HttpStatus.OK)).body(claim.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @PutMapping("{id}")
    public void updateClaim(@PathVariable Integer id, @RequestBody Claim claim) {
        claimService.updateClaim(id,claim);
    }

    @DeleteMapping("{id}")
    public void deleteClaim(@PathVariable Integer id) {
        claimService.deleteClaim(id);
    }
}
