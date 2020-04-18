package it.contrader.controller;

import java.util.*;

import it.contrader.dto.WarehouseDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.WarehouseService;

/*controller dell'utente non admin*/
public class WarehouseUserController implements Controller{
	
	private static String sub_package = "warehouseuser.";
	
	private WarehouseService warehouseService;
	
	public WarehouseUserController() {
		this.warehouseService = new WarehouseService();
	}
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		int id;
		String city;
		int capacity;
		
		switch (mode) {

			case "READ":
				id = Integer.parseInt(request.get("id").toString());
				
				WarehouseDTO warehouseDTO = warehouseService.read(id);
				request.put("warehouse", warehouseDTO);
				MainDispatcher.getInstance().callView(sub_package + "WarehouseUserRead", request);
				break;
			
			case "INSERT":
				city = request.get("city").toString();
				capacity = Integer.parseInt(request.get("capacity").toString());
				
				WarehouseDTO warehousetoinsert = new WarehouseDTO(city,capacity);
				warehouseService.insert(warehousetoinsert);
				request = new Request();
				request.put("mode","mode");
				MainDispatcher.getInstance().callView(sub_package + "WarehouseUserInsert", request);
				break;
				
			case "WAREHOUSELIST":
				List<WarehouseDTO> warehousesDTO = warehouseService.getAll();

				request.put("warehouses", warehousesDTO);
				MainDispatcher.getInstance().callView("WarehouseUser", request);
				break;
			
			//gestione della scelta utente
			case "GETCHOICE":
						//toUpperCase() mette in maiuscolo la scelta
				switch (choice.toUpperCase()) {
				
				case "L":
					MainDispatcher.getInstance().callView(sub_package + "WarehouseUserRead", null);
					break;
					
				case "I":
					MainDispatcher.getInstance().callView(sub_package + "WarehouseUserInsert", null);
					break;

				case "E":
					MainDispatcher.getInstance().callView("Login", null);
					break;

				case "B":
					MainDispatcher.getInstance().callView("HomeUser", null);
					break;
					
				default:
					MainDispatcher.getInstance().callView("Login", null);
				}
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
	}
	

}
