package it.contrader.dto;

public class SupplierDTO {
	private int     id;
	private String  name;
	private String  country;
	private String  email;
	
	public SupplierDTO () {
	}
	
	public SupplierDTO (String name, String country, String email) {
		this.name           = name;
		this.country        = country;
		this.email          = email;
	}
	
	public SupplierDTO (int id, String name, String country, String email) {
		this.id             = id;
		this.name           = name;
		this.country        = country;
		this.email          = email;
	}

	public int getId () {
		return this.id;
	}
	public void setID (int id) {
		this.id = id;
	}
	public String getName () {
		return this.name;
	}
	public void setName (String name) {
		this.name = name;
	}
	public String getCountry () {
		return this.country;
	}
	public void setCountry (String country) {
		this.country = country;
	}
	public String getEmail () {
		return this.email;
	}
	public void setEmail (String email) {
		this.email = email;
	}
	
	@Override
	public String toString () {
		return id + "\t" + name + "\t\t" + country + "\t\t" + email;
	}
}
