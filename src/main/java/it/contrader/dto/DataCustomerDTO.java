package it.contrader.dto;

//import it.contrader.model.DataCustomer.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class DataCustomerDTO {


	private Long id;

	private String name;

	private String surname;
	
	private int age;
	
	private String email;
	
	private String phoneNumber;

	//private Usertype usertype;
	
}
 