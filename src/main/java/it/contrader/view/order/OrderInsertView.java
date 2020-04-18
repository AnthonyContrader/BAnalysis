package it.contrader.view.order;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OrderInsertView extends AbstractView{

	private Request request;
	private int id;
	private int quantity;
	private String orderNumber;
	private String date;

	private final String mode = "INSERT";

	// se la request viene dal mode INSERT del controller, quindi non nulla. Mostro l'esito dell'operazione
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Order", null);
		}
		
	}

	//chiedo all'utente di inserire gli attributi dell'utente
	@Override
	public void showOptions() {
		System.out.println("Inserisci quantitativo ordine:");
		quantity = Integer.parseInt(getInput());
		System.out.println("Inserisci identificativo dell'ordine:");
		orderNumber = getInput();
		System.out.println("Inserisci data dell'ordine:");
		date = getInput();
		
	}

	@Override
	public void submit() {

		request = new Request();
		request.put("id", id);
		request.put("quantity", quantity);
		request.put("orderNumber", orderNumber);
		request.put("date", date);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Order", "doControl", request);
		
	}

}
