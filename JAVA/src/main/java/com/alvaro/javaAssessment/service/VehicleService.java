package com.alvaro.javaAssessment.service;

import com.alvaro.javaAssessment.model.Owner;
import com.alvaro.javaAssessment.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    public Vehicle saveVehicle(Vehicle vehicle);
    public List<Vehicle> getAllVehicles();
    public Optional<Vehicle> getVehicle(Integer id);
    public void updateVehicle(Integer id, Vehicle vehicle);
    public void deleteVehicle(Integer id);
}
