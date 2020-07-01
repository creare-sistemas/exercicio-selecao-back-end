package br.com.crearesistemas.frota.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {

	private long id;
	private String plate;
	private String renavam;
	private String model;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String plate, String renavam, String model) {
		this.plate = plate;
		this.renavam = renavam;
		this.model = model;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "plate", nullable = false)
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	@Column(name = "renavam", nullable = false)
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	
	@Column(name = "model", nullable = false)
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", plate=" + plate + ", renavam=" + renavam + ", model=" + model
				+ "]";
	}
	
}
