package com.alvaro.javaAssessment.controller;

import com.alvaro.javaAssessment.model.Claim;
import com.alvaro.javaAssessment.model.Vehicle;
import com.alvaro.javaAssessment.service.ClaimService;
import com.alvaro.javaAssessment.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping()
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.OK).body("User: " + vehicle.getVin() + " added");
    }

    @GetMapping()
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable Integer id) {
        Optional<Vehicle> vehicle = vehicleService.getVehicle(id);
        if (vehicle.isPresent())
            return ResponseEntity.status((HttpStatus.OK)).body(vehicle.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("{id}")
    public void updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle) {
        vehicleService.updateVehicle(id,vehicle);
    }

    @DeleteMapping("{id}")
    public void deleteVehicle(@PathVariable Integer id) {
        vehicleService.deleteVehicle(id);
    }
}
