package it.contrader.view.warehouse;

import it.contrader.dto.WarehouseDTO;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class WarehouseReadView extends AbstractView{
	
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public WarehouseReadView() {}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			WarehouseDTO warehouse = (WarehouseDTO) request.get("warehouse");
			System.out.println(warehouse);
			MainDispatcher.getInstance().callView("Warehouse", null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del magazzino:");
		id = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Warehouse", "doControl", request);		
	}	
}
