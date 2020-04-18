package it.contrader.dto;

import java.util.List;

public class WarehouseDTO {
	private int id;
	private String city;
	private int capacity;//capienza massima magazzino
	
	public WarehouseDTO() {}

	public WarehouseDTO(String city, int capacity) {
		this.city = city;
		this.capacity = capacity;
	}

	public WarehouseDTO(int id, String city, int capacity) {
		this.id = id;
		this.city = city;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return  id + "\t"  + city + "\t\t" + capacity;

	}

}