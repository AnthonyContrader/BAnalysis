package it.contrader.controller;
import java.util.*;

import it.contrader.dto.WarehouseDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.WarehouseService;

public class WarehouseController implements Controller {
	
	private static String sub_package = "warehouse.";
	
	private WarehouseService warehouseService;
	
	public WarehouseController() {
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
				MainDispatcher.getInstance().callView(sub_package + "WarehouseRead", request);
				break;
			
			case "INSERT":
				city = request.get("city").toString();
				capacity = Integer.parseInt(request.get("capacity").toString());
				
				WarehouseDTO warehousetoinsert = new WarehouseDTO(city,capacity);
				warehouseService.insert(warehousetoinsert);
				request = new Request();
				request.put("mode","mode");
				MainDispatcher.getInstance().callView(sub_package + "WarehouseInsert", request);
				break;
		
			case "DELETE":
				id = Integer.parseInt(request.get("id").toString());

				warehouseService.delete(id);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "WarehouseDelete", request);
				break;
			
			case "UPDATE":
				id = Integer.parseInt(request.get("id").toString());
				city = request.get("city").toString();
				capacity = Integer.parseInt(request.get("capacity").toString());
				
				WarehouseDTO warehousetoupdate = new WarehouseDTO(city,capacity);
				warehousetoupdate.setId(id);
				
				System.out.println("case UPDATE");
				
				warehouseService.update(warehousetoupdate);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "WarehouseUpdate", request);
				break;
				
			case "WAREHOUSELIST":
				List<WarehouseDTO> warehousesDTO = warehouseService.getAll();

				request.put("warehouses", warehousesDTO);
				MainDispatcher.getInstance().callView("Warehouse", request);
				break;
			
			//gestione della scelta utente
			case "GETCHOICE":
						
						//toUpperCase() mette in maiuscolo la scelta
				switch (choice.toUpperCase()) {
				
				case "L":
					MainDispatcher.getInstance().callView(sub_package + "WarehouseRead", null);
					break;
					
				case "I":
					MainDispatcher.getInstance().callView(sub_package + "WarehouseInsert", null);
					break;
					
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "WarehouseUpdate", null);
					break;
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "WarehouseDelete", null);
					break;
					
				case "E":
					MainDispatcher.getInstance().callView("Login", null);
					break;

				case "B":
					MainDispatcher.getInstance().callView("HomeAdmin", null);
					break;
					
				default:
					MainDispatcher.getInstance().callView("Login", null);
				}
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
	}

}
