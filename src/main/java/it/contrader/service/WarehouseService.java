package it.contrader.service;

import java.util.*;

import it.contrader.converter.WarehouseConverter;
import it.contrader.dao.WarehouseDAO;
import it.contrader.dto.WarehouseDTO;

public class WarehouseService {

		private WarehouseDAO warehouseDAO;
		private WarehouseConverter warehouseConverter;
		
		public WarehouseService() {
			this.warehouseDAO = new WarehouseDAO();
			this.warehouseConverter = new WarehouseConverter();
		}
		
		// ritorna Lista di entità convertita in DTO
		public List<WarehouseDTO> getAll(){
			return warehouseConverter.toDTOList(warehouseDAO.getAll());
		}
		
		//ritorna una entità convertita in DTO
		public WarehouseDTO read(int id) {
			return warehouseConverter.toDTO(warehouseDAO.read(id));
		}
		
		//DTO in entità  -> entità al DAO -> inserimento
		public boolean insert(WarehouseDTO warehouseDTO) {
			return warehouseDAO.insert(warehouseConverter.toEntity(warehouseDTO));
		}
		
		//DTO in entità -> entità al DAO -> modifica
		public boolean update(WarehouseDTO warehouseDTO) {
			return warehouseDAO.update(warehouseConverter.toEntity(warehouseDTO));
		}
		
		//richiamo il DAO per la cancellazione
		public boolean delete(int id) {
			return warehouseDAO.delete(id);
		}
		
		
}
