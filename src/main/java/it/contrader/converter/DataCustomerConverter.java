package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DataCustomerDTO;
import it.contrader.model.DataCustomer;


@Component

public class DataCustomerConverter extends AbstractConverter<DataCustomer, DataCustomerDTO> {

	@Override
	public DataCustomer toEntity(DataCustomerDTO datacustomerDTO) {
		DataCustomer datacustomer = null;
		if (datacustomerDTO != null)
		{
			datacustomer = new DataCustomer(datacustomerDTO.getId(), datacustomerDTO.getName(), datacustomerDTO.getSurname(), datacustomerDTO.getAge(), datacustomerDTO.getEmail(), datacustomerDTO.getPhoneNumber());
		}
		return datacustomer;
	}

	@Override
	public DataCustomerDTO toDTO(DataCustomer datacustomer) {
		DataCustomerDTO datacustomerDTO = null;
		if(datacustomer != null)
		{
			datacustomerDTO = new DataCustomerDTO(datacustomer.getId(), datacustomer.getName(), datacustomer.getSurname(), datacustomer.getAge(), datacustomer.getEmail(), datacustomer.getPhoneNumber());
		}
		return datacustomerDTO;
	}

	
	
	
}
