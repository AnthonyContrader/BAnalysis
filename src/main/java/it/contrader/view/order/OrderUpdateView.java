package it.contrader.view.order;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OrderUpdateView extends AbstractView {
	private Request request;
	private int id;
	private int quantity;
	private String orderNumber;
	private String date;
	private final String mode = "UPDATE";

	public OrderUpdateView() {
	}

	// controllo se la request sia null, in caso negativo mostro l'esito
	// dell'operazione
	@Override
	public void showResults(Request request) {
		if(request != null) {

			System.out.println("Ordine modificato con successo.\n");
			MainDispatcher.getInstance().callView("Order", null);
		}

	}

	// chiede all'utente di inserire gli attributi dell'ordine che intendo
	// modificare
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id ordine: ");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci quantitativo dell'ordine:");
			quantity = Integer.parseInt(getInput());
			System.out.println("Inserisci numero dell'ordine:");
			orderNumber = getInput();
			System.out.println("Inserisci la data:");
			date = getInput();


		} catch (Exception e) {
		}

	}

	//inpacchetta la request coi metodi inseriti nel metodo showOptions()
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
