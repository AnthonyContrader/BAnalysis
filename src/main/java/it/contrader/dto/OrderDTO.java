package it.contrader.dto;

import it.contrader.model.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {

	private Long id;
	private int quantity;
	private String orderNumber;
	private String date;
	private Supplier supplier;
}
