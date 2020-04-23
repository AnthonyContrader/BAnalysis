package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DataCustomerDTO;
import it.contrader.model.DataCustomer;

public class DataCustomerConverter  implements Converter<DataCustomer, DataCustomerDTO> {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public DataCustomerDTO toDTO(DataCustomer datacustomer) {
		DataCustomerDTO DataCustomerDTO = new DataCustomerDTO(datacustomer.getName(), datacustomer.getSurname(), datacustomer.getAge(), datacustomer.getEmail(), datacustomer.getPhoneNumber(), datacustomer.getId());
		return DataCustomerDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public DataCustomer toEntity(DataCustomerDTO datacustomerDTO) {
		DataCustomer datacustomer = new DataCustomer(datacustomerDTO.getName(), datacustomerDTO.getSurname(), datacustomerDTO.getAge(), datacustomerDTO.getEmail(), datacustomerDTO.getPhoneNumber(), datacustomerDTO.getId());
		return datacustomer;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	@Override
	public List<DataCustomerDTO> toDTOList(List<DataCustomer> datacustomerList) {
		//Crea una lista vuota.
		List<DataCustomerDTO> datacustomerDTOList = new ArrayList<DataCustomerDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(DataCustomer datacustomer : datacustomerList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			datacustomerDTOList.add(toDTO(datacustomer));
		}
		return datacustomerDTOList;
	}


}
