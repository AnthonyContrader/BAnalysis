package it.contrader.view.warehouse;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class WarehouseInsertView extends AbstractView {
	
	private Request request;
	
	private String city;
	private int capacity;
	
	private final String mode = "INSERT";
	
	public WarehouseInsertView() {}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Warehouse", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci città del magazzino:");
			city = getInput();
			System.out.println("Inserisci capacità  del magazzino:");
			capacity = Integer.parseInt(getInput());
					
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("city", city);
		request.put("capacity", capacity);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Warehouse", "doControl", request);
	}
}
