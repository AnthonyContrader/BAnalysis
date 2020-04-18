package it.contrader.view;
import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.DataCustomerDTO;
import it.contrader.main.MainDispatcher;
public class DataCustomerView extends AbstractView{
	private Request request;
	private String choice;
	
	public DataCustomerView()
	{
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione utenti ----------------\n");
			System.out.println("ID\tName\tSurname\tAge\tEmail\tPhoneNumber");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<DataCustomerDTO> datacustomers = (List<DataCustomerDTO>) request.get("datacustomers");
			for (DataCustomerDTO d: datacustomers)
				System.out.println(d);
			System.out.println();
		}
		
	}

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
		MainDispatcher.getInstance().callAction("DataCustomer", "doControl", this.request);
		
	}
	
	

}
