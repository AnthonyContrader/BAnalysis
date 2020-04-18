package it.contrader.converter;

import java.util.*;

import it.contrader.dto.WarehouseDTO;
import it.contrader.model.Warehouse;

public class WarehouseConverter {
	//da warehouse a warehouseDTO
	public WarehouseDTO toDTO(Warehouse warehouse) {
		WarehouseDTO warehouseDTO = new WarehouseDTO(warehouse.getId(),warehouse.getCity(), warehouse.getCapacity());
		return warehouseDTO;
	}
	
	//da warehouseDTO a warehouse
	public Warehouse toEntity(WarehouseDTO warehouseDTO) {
		Warehouse warehouse = new Warehouse(warehouseDTO.getId(), warehouseDTO.getCity(), warehouseDTO.getCapacity());
		return warehouse;
	}
	
	//converti liste da entità a DTO
	public List<WarehouseDTO> toDTOList(List<Warehouse> warehouseList){
		List<WarehouseDTO> warehouseDTOList = new ArrayList<WarehouseDTO>();
		for(Warehouse wh : warehouseList) {
			warehouseDTOList.add(toDTO(wh));
		}
		return warehouseDTOList;	
	}
}
