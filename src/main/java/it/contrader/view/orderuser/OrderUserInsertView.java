package it.contrader.view.orderuser;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OrderUserInsertView extends AbstractView {

 	private Request request;
	private int quantity;
	private String orderNumber;
	private String date;
	private final String mode = "INSERT";

	public OrderUserInsertView() {
		System.out.println("Sono in OrderUserInsert");
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("OrderUser", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.println("showOptions in OrderUserInsert");
		System.out.println("Scegli la quantita da inserire");
		quantity = Integer.parseInt(getInput());
		System.out.println("Inserisci il codice dell'ordine:");
		orderNumber = getInput();
		System.out.println("Inserisci la data dell'ordine");
		date = getInput();

	}

	@Override
	public void submit() {
		System.out.println("submit in OrderUserInsert");
		request = new Request();
		request.put("quantity", quantity);
		request.put("orderNumber", orderNumber);
		request.put("date", date);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("OrderUser", "doControl", request);

	}

}
