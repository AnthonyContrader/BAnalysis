package it.contrader.view.warehouse;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class WarehouseUpdateView extends AbstractView{
	private Request request;
	
	private int id;
	private String city;
	private int capacity;
	
	private final String mode = "UPDATE";
	
	public WarehouseUpdateView() {}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Warehouse", null);
		}
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del magazzino:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci la città del magazzino:");
			city = getInput();
			System.out.println("Inserisci la capacità del magazzino:");
			capacity = Integer.parseInt(getInput());
			
		} catch (Exception e) {}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("city", city);
		request.put("capacity", capacity);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Warehouse", "doControl", request);
	}

}
