package it.contrader.service;
import it.contrader.converter.DataCustomerConverter;
import it.contrader.dao.DataCustomerDAO;
import it.contrader.dto.DataCustomerDTO;
import it.contrader.model.DataCustomer;

public class DataCustomerService extends AbstractService<DataCustomer, DataCustomerDTO> {

	//Istanzio DAO  e Converter specifici.
	public DataCustomerService(){
		this.dao = new DataCustomerDAO();
		this.converter = new DataCustomerConverter();
	}
	

}
