package it.contrader.view;

import java.util.*;

import it.contrader.controller.Request;
import it.contrader.dto.WarehouseDTO;
import it.contrader.main.MainDispatcher;

/*Classe che presenta la View per l'utente*/
public class WarehouseUserView extends AbstractView{
	
	private Request request;
	private String choice;
	
	public WarehouseUserView() {}
	
	//stampa magazzini
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Magazzino ----------------\n");
			System.out.println("ID\tCittà\t\tCapienza");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<WarehouseDTO> warehouses = (List<WarehouseDTO>) request.get("warehouses");
			for (WarehouseDTO u: warehouses)
				System.out.println(u);
			System.out.println();
		}	
	}
	
	//stampa opzioni
	@Override
	public void showOptions() {
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [B]ack [E]sci");
		
		this.choice = getInput();
	}
	
	//invio dati
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("WarehouseUser", "doControl", this.request);
	}	
}
