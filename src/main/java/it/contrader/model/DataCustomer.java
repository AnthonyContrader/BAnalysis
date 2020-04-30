package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;

import it.contrader.model.DataCustomer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity


public class DataCustomer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 
	private Long id;

	@Column(unique = true)

  
	private String name;

 
	private String surname;
	
	private int age;
	
	private String email;
	
	private String phoneNumber;

 	//@Enumerated(EnumType.STRING)
	//private Usertype usertype;
	
}
