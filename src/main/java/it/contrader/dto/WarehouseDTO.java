package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class WarehouseDTO {
	
	private Long id;
	private String city;
	private int capacity;

}
