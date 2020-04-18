package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.dto.OrderDTO;
import it.contrader.main.MainDispatcher;

public class OrderView extends AbstractView {

	private Request request;
	private String choice;

	
	public OrderView() {
	}
	
	// mostro la lista ordini
	@Override
	public void showResults(Request request) {
		System.out.println(request == null);
		if (request != null) {
			System.out.println("\n-------------------GESTIONE ORDINI----------------\n");
			System.out.println("ID\tQuantita\tNumero Ordine\tData");
			System.out.println("----------------------------------------------------\n");

			@SuppressWarnings("unchecked")
			List<OrderDTO> orders = (List<OrderDTO>) request.get("orders");
			for (OrderDTO o : orders)
				System.out.println(o);
			System.out.println();
		}
		 

	}

	// chiedo all'utente di effettuare una scelta da console per la choice (tutto a OrderController)
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		this.choice = getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Order", "doControl", this.request);

	}

}
