package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class User {
//
 

	public enum Usertype {
		ADMIN, USER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 
	private Long id;

	@Column(unique = true)

 
	private String username;

 
	private String password;

 	@Enumerated(EnumType.STRING)
	private Usertype usertype;

}
