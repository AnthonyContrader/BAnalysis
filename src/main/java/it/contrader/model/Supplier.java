package it.contrader.model;

public class Supplier {
	private int     id;
	private String  name;
	private String  country;
	private String  email;
	
	public Supplier () {
	}
	
	public Supplier (String name, String country, String email) {
		this.name           = name;
		this.country        = country;
		this.email          = email;
	}
	
	public Supplier (int id, String name, String country, String email) {
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
