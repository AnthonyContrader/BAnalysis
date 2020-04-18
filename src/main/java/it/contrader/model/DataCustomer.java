package it.contrader.model;

public class DataCustomer {
	
	@Override
	public String toString() {
		return "DataCustomer [name=" + name + ", surname=" + surname + ", age=" + age + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", id=" + id + "]";
	}
	private String name;
	private String surname;
	private int age;
	private String email;
	private String phoneNumber;
	private int id;
	
	public DataCustomer()
	{}
    public DataCustomer(String name,String surname, int age, String email, String phoneNumber, int id)
    {
    	this.name=name;
    	this.surname=surname;
    	this.age=age;
    	this.email=email;
    	this.phoneNumber=phoneNumber;
    	this.id=id;
    	
    }
    
    
	public DataCustomer(String name, String surname, int age, String email, String phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber==null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataCustomer other = (DataCustomer) obj;
		if (age != other.age)
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
		if (phoneNumber != other.phoneNumber)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	}
	
	
	
	


