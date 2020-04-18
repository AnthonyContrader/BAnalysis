package it.contrader.view.order;

import it.contrader.controller.Request;
import it.contrader.dto.OrderDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OrderReadView extends AbstractView{
	
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public OrderReadView() {
		
	}

	/*
	 	se la request null (ovvero quando arriva dal controller con mode GETCHOICE e choice L il metodo risulta vuoto.
	 	altrimenti se viene da un order nella request (ovvero quando arriva dal controller con il metodo READ) mostra l'ordine. 
	 	In questo caso torna alla OrderView

	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			OrderDTO order = (OrderDTO) request.get("order");
			System.out.println(order);
			MainDispatcher.getInstance().callView("Order", null);
		}
		
	}
	
	/**
	 * chiedo all'utente di inserire l'id dell'ordine da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Scegli l'ID dell'ordine");
		id = Integer.parseInt(getInput());
		
	}

	/**
	 * impacchetta una request con l'id dell'ordine da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Order", "doControl", request);

	}

}
