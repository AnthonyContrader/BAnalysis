package it.contrader.converter;

import java.util.*;

import it.contrader.dto.WarehouseDTO;
import it.contrader.model.Warehouse;

public class WarehouseConverter implements Converter<Warehouse, WarehouseDTO>{
	//da warehouse a warehouseDTO
	@Override
	public WarehouseDTO toDTO(Warehouse warehouse) {
		WarehouseDTO warehouseDTO = new WarehouseDTO(warehouse.getId(),warehouse.getCity(), warehouse.getCapacity());
		return warehouseDTO;
	}
	
	//da warehouseDTO a warehouse
	@Override
	public Warehouse toEntity(WarehouseDTO warehouseDTO) {
		Warehouse warehouse = new Warehouse(warehouseDTO.getId(), warehouseDTO.getCity(), warehouseDTO.getCapacity());
		return warehouse;
	}
	
	//converti liste da entità a DTO
	@Override
	public List<WarehouseDTO> toDTOList(List<Warehouse> warehouseList){
		List<WarehouseDTO> warehouseDTOList = new ArrayList<WarehouseDTO>();
		for(Warehouse wh : warehouseList) {
			warehouseDTOList.add(toDTO(wh));
		}
		return warehouseDTOList;	
	}
}
