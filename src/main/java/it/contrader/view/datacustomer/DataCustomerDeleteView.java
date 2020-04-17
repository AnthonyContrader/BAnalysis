package it.contrader.view.datacustomer;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
//import java.util.*;
import it.contrader.view.AbstractView;
public class DataCustomerDeleteView extends AbstractView{
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public DataCustomerDeleteView()
	{}

	@Override
	public void showResults(Request request) {
		if (request!=null)
		{
		System.out.println("Cancellazione andata a buon fine.\n");
		MainDispatcher.getInstance().callView("DataCustomer", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci id dell'utente:");
		id = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("DataCustomer", "doControl", request);
		
	}
	

}
