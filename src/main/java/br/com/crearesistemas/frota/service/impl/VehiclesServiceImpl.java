package br.com.crearesistemas.frota.service.impl;

import br.com.crearesistemas.frota.entity.Vehicle;
import br.com.crearesistemas.frota.exception.ResourceNotFoundException;
import br.com.crearesistemas.frota.repository.VehicleRepository;
import br.com.crearesistemas.frota.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Service
public class VehiclesServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    MessageSource messageSource;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) throws ResourceNotFoundException {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("error.notfound", new Object[]{vehicleId}, LocaleContextHolder.getLocale())));
        return vehicle;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicleDetails) throws ResourceNotFoundException {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("error.notfound", new Object[]{vehicleId}, LocaleContextHolder.getLocale())));

        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setRenavam(vehicleDetails.getRenavam());
        final Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return updatedVehicle;
    }

    @Override
    public void deleteVehicle(Long vehicleId) throws ResourceNotFoundException {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("error.notfound", new Object[]{vehicleId}, LocaleContextHolder.getLocale())));
        vehicleRepository.delete(vehicle);
    }
}
