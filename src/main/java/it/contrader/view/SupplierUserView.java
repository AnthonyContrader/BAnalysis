package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.SupplierDTO;
import it.contrader.main.MainDispatcher;

public class SupplierUserView extends AbstractView {

	private Request request;
	private String choice;

	public SupplierUserView() {
		
	}

	// Mostra la lista
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione fornitori -------------\n");
			System.out.println("ID\tNome\tPaese\tEmail");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<SupplierDTO> suppliers = (List<SupplierDTO>) request.get("suppliers");
			for (SupplierDTO u: suppliers)
				System.out.println(u);
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
		MainDispatcher.getInstance().callAction("SupplierUser", "doControl", this.request);
	}
}
