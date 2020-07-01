package br.com.crearesistemas.frota.repository;

import br.com.crearesistemas.frota.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
