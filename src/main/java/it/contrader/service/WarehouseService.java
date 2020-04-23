package it.contrader.service;

import it.contrader.converter.WarehouseConverter;
import it.contrader.dao.WarehouseDAO;
import it.contrader.dto.WarehouseDTO;
import it.contrader.model.Warehouse;


public class WarehouseService extends AbstractService<Warehouse, WarehouseDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public WarehouseService(){
		this.dao = new WarehouseDAO();
		this.converter = new WarehouseConverter();
	}
}
