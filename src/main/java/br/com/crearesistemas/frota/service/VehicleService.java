package br.com.crearesistemas.frota.service;

import br.com.crearesistemas.frota.entity.Vehicle;
import br.com.crearesistemas.frota.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(Long vehicleId) throws ResourceNotFoundException;

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Long vehicleId, Vehicle vehicleDetails) throws ResourceNotFoundException;

    void deleteVehicle(Long vehicleId) throws ResourceNotFoundException;
}
