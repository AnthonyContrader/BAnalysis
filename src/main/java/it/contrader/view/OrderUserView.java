package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.OrderDTO;
import it.contrader.main.MainDispatcher;

public class OrderUserView extends AbstractView {

	private Request request;
	private String choice;

	public OrderUserView() {
		
	}

	// Mostra la lista
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione ordini -------------\n");
			System.out.println("ID\tQuantita\tNumero Ordine\tData");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<OrderDTO> orders = (List<OrderDTO>) request.get("orders");
			for (OrderDTO o: orders)
				System.out.println(o);
			System.out.println();
		}
	}

	// Chiede all'utente un input (lettera da tastiera) per la choice (vedi Controller). 
	// Mette la modalità GETCHOICE nella mode.
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [B]ack [E]sci");
		this.choice = getInput();
	}
	
	// Impacchetta la request e la manda al Controller.
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("OrderUser", "doControl", this.request);
	}
}
