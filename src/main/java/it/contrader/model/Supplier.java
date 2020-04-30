package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name="supplier")
public class Supplier {
	
//	public Supplier() {
//		System.out.println("Sono nel costruttore di Supplier()");
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

//	@Column(unique = true)
	@Column(name="id")
	private Long    id;
	
	@Column(name="name")
	private String  name;
	
	@Column(name="country")
	private String  country;
	
	@Column(name="email")
	private String  email;

	@Override
	public String toString() {
		return " name=" + name + ", country=" + country + ", email=" + email + "";
	}
	
	
	
}
