package br.com.crearesistemas.frota.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.crearesistemas.frota.entity.Vehicle;
import br.com.crearesistemas.frota.exception.ResourceNotFoundException;
import br.com.crearesistemas.frota.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class VehicleControllerV1 {
	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

	@GetMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Long vehicleId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(vehicleService.getVehicleById(vehicleId));
	}

	@PostMapping("/vehicles")
	public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {
		return vehicleService.createVehicle(vehicle);
	}

	@PutMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable(value = "id") Long vehicleId,
			@Valid @RequestBody Vehicle vehicleDetails) throws ResourceNotFoundException {
		return ResponseEntity.ok(vehicleService.updateVehicle(vehicleId, vehicleDetails));
	}

	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<Void> deleteVehicle(@PathVariable(value = "id") Long vehicleId)
			throws ResourceNotFoundException {
		vehicleService.deleteVehicle(vehicleId);

		return (ResponseEntity<Void>) ResponseEntity.noContent();

	}
}
