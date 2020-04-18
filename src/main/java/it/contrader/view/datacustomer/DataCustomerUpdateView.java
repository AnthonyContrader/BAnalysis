package it.contrader.view.datacustomer;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DataCustomerUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String name;
	private String surname;
    private int age;
    private String email;
    private String phoneNumber;
    private final String mode = "UPDATE";
    public DataCustomerUpdateView()
	{}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("DataCustomer", null);
		}
		
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del cliente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome del cliente:");
			name = getInput();
			System.out.println("Inserisci cognome del cliente:");
			surname = getInput();
			System.out.println("Inserisci età del cliente:");
			age = Integer.parseInt(getInput());
			System.out.println("Insersic email del cliente:");
			email = getInput();
			System.out.println("Inserisci numero di telefono del cliente");
			phoneNumber = getInput();
		}
		catch (Exception e)
		{}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("surname", surname);
		request.put("age", age);
		request.put("email", email);
		request.put("phoneNumber", phoneNumber);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("DataCustomer", "doControl", request);
		
	}

	
}
