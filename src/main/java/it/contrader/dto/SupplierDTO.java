package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import it.contrader.model.Supplier;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SupplierDTO {

	private Long    id;
	private String  name;
	private String  country;
	private String  email;

}
