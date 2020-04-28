package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.WarehouseDTO;

import it.contrader.model.Warehouse;

@Component
public class WarehouseConverter extends AbstractConverter<Warehouse, WarehouseDTO>{

	@Override
	public Warehouse toEntity(WarehouseDTO warehouseDTO) {
		Warehouse warehouse = null;
		if (warehouseDTO != null) {
			warehouse = new Warehouse(warehouseDTO.getId(), warehouseDTO.getCity(), warehouseDTO.getCapacity());
		}
		return warehouse;
	}

	@Override
	public WarehouseDTO toDTO(Warehouse warehouse) {
		WarehouseDTO warehouseDTO = null;
		if (warehouse != null) {
			warehouseDTO = new WarehouseDTO(warehouse.getId(), warehouse.getCity(), warehouse.getCapacity());
		}
		return warehouseDTO;
	}
}
