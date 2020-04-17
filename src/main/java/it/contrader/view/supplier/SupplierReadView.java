package it.contrader.view.supplier;

import it.contrader.controller.Request;

import it.contrader.dto.*;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SupplierReadView extends AbstractView {
	private int id;
	private Request request;
	private final String mode = "READ";

	public SupplierReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con un elemento nella request (ovvero quando arriva
	 * dal controller con mode READ) lo mostra. In questo caso torna alla View senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			SupplierDTO supplier = (SupplierDTO) request.get("supplier");
			System.out.println(supplier);
			MainDispatcher.getInstance().callView("Supplier", null);
		}
	}
	
	// chiede all'utente di inserire l'id dell'utente da leggere
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del fornitore:");
		id = Integer.parseInt(getInput());
	}

	// impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Supplier", "doControl", request);
	}
}
