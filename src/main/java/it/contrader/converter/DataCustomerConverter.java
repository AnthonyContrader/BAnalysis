package it.contrader.converter;
import java.util.*;
import it.contrader.dto.DataCustomerDTO;
import it.contrader.model.DataCustomer;

public class DataCustomerConverter {

	public DataCustomerDTO toDTO(DataCustomer datacustomer) {
		DataCustomerDTO datacustomerDTO = new DataCustomerDTO(datacustomer.getName(), datacustomer.getSurname(), datacustomer.getAge(), datacustomer.getEmail(), datacustomer.getPhoneNumber(), datacustomer.getId());
		return datacustomerDTO;
	}
	public DataCustomer toEntity(DataCustomerDTO datacustomerDTO) {
		DataCustomer datacustomer = new DataCustomer(datacustomerDTO.getName(), datacustomerDTO.getSurname(), datacustomerDTO.getAge(), datacustomerDTO.getEmail(), datacustomerDTO.getPhoneNumber(), datacustomerDTO.getId());
		return datacustomer;
	}
		public List<DataCustomerDTO> toDTOList(List<DataCustomer> list) {
			
			List<DataCustomerDTO> datacustomerDTOList = new ArrayList<DataCustomerDTO>();
			
			
			for(DataCustomer datacustomer : list) {
				
				((ArrayList<DataCustomerDTO>) datacustomerDTOList).add(toDTO(datacustomer));
			}
			return datacustomerDTOList;
		}

}
