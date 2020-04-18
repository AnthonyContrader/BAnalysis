package it.contrader.view.orderuser;

import it.contrader.controller.Request;
import it.contrader.dto.OrderDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OrderUserReadView extends AbstractView {
	private int id;
	private Request request;
	private final String mode = "READ";

	public OrderUserReadView() {
//		System.out.println("Sono in OrderUserRead");
	}

	@Override
	public void showResults(Request request) {
		System.out.println("");
		if (request != null) {
			OrderDTO order = (OrderDTO) request.get("order");
			System.out.println(order);
			MainDispatcher.getInstance().callView("OrderUser", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'ordine:");
		id = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("OrderUser", "doControl", request);

	}

}
