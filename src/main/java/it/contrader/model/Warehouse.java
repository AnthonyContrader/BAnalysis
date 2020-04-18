package it.contrader.model;

import java.util.*;

public class Warehouse {
	private int id;
	private String city;
	private int capacity;//capienza massima magazzino
	
	public Warehouse() {}

	public Warehouse(String city, int capacity) {
		this.city = city;
		this.capacity = capacity;
	}

	public Warehouse(int id, String city, int capacity) {
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

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		if (capacity != other.capacity)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	

}
