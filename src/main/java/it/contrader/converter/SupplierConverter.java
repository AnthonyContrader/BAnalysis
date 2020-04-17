package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SupplierDTO;
import it.contrader.model.Supplier;

public class SupplierConverter {

	/**
	 * Crea un oggetto di tipo SupplierDTO e lo riempie con i campi del parametro supplier di tipo Supplier.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public SupplierDTO toDTO(Supplier supplier) {
		SupplierDTO supplierDTO = new SupplierDTO(supplier.getId(), supplier.getName(), supplier.getCountry(), supplier.getEmail());
		return supplierDTO;
	}

	/**
	 * Crea un oggetto di tipo Supplier e lo riempie con i campi del parametro user di tipo SupplierDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Supplier toEntity(SupplierDTO supplierDTO){
		Supplier supplier = new Supplier(supplierDTO.getId(), supplierDTO.getName(), supplierDTO.getCountry(), supplierDTO.getEmail());
		return supplier;
	}
	
	/**
	 * Metodo per convertire le liste di Supplier.
	 */
	public List<SupplierDTO> toDTOList(List<Supplier> supplierList) {
		//Crea una lista vuota.
		List<SupplierDTO> supplierDTOList = new ArrayList<SupplierDTO>();

		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Supplier supplier : supplierList) {

			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge alla lista di DTO
			supplierDTOList.add(toDTO(supplier));
		}
		return supplierDTOList;
	}
}
