package it.contrader.service;

import it.contrader.converter.SupplierConverter;
import it.contrader.dao.SupplierDAO;
import it.contrader.dto.SupplierDTO;
import it.contrader.model.Supplier;

public class SupplierService extends AbstractService<Supplier, SupplierDTO> {

	//Istanzio DAO  e Converter specifici.
	public SupplierService(){
		this.dao = new SupplierDAO();
		this.converter = new SupplierConverter();
	}
	

}
