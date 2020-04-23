package it.contrader.dto;

public class DataCustomerDTO {
	
	private String name;
	private String surname;
	private int age;
	private String email;
	private String phoneNumber;
	private int id;
	
	public DataCustomerDTO () {
	}
	
	public DataCustomerDTO (String name, String surname, int age, String email, String phoneNumber) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public DataCustomerDTO (String name, String surname, int age, String email, String phoneNumber, int id) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.id = id;
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
	public String toString() {
		return "DataCustomerDTO [name=" + name + ", surname=" + surname + ", age=" + age + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", id=" + id + "]";
	}

	
	}
	

