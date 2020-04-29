package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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

public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(unique = true)
	private Long    id;
	private String  name;
	private String  country;
	private String  email;
	
}
