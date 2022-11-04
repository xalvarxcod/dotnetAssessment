package com.alvaro.javaAssessment.service;

import com.alvaro.javaAssessment.model.Owner;
import com.alvaro.javaAssessment.model.Vehicle;
import com.alvaro.javaAssessment.repository.OwnerRepository;
import com.alvaro.javaAssessment.repository.VehicleRepository;
import net.bytebuddy.build.RepeatedAnnotationPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicle(Integer id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public void updateVehicle(Integer id, Vehicle vehicle) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        if (!vehicleOptional.isPresent()) {
            vehicle.setId(id);
            vehicleRepository.save(vehicle);
        } else {
            Vehicle vehicleFound = vehicleOptional.get();
            vehicleFound.setBrand(vehicle.getBrand());
            vehicleFound.setColor(vehicle.getColor());
            vehicleFound.setOwner(vehicle.getOwner());
            vehicleFound.setVin(vehicle.getVin());
            vehicleFound.setYear(vehicle.getYear());
            vehicleRepository.save(vehicleFound);
        }
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
