package it.contrader.view.datacustomer;
import it.contrader.controller.Request;
import it.contrader.dto.DataCustomerDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
public class DataCustomerReadView extends AbstractView{
	private int id;
	private Request request;
	private final String mode = "READ";
	
   public DataCustomerReadView()
   {}

@Override
public void showResults(Request request) {
	if (request != null) {
		DataCustomerDTO datacustomer = (DataCustomerDTO) request.get("datacustomer");
		System.out.println(datacustomer);
		MainDispatcher.getInstance().callView("DataCustomer", null);
	
}
}

@Override
public void showOptions() {
	System.out.println("Inserisci l'ID dell'utente:");
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
