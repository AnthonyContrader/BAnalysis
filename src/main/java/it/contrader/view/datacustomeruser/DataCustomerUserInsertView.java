package it.contrader.view.datacustomeruser;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
public class DataCustomerUserInsertView extends AbstractView {

private Request request;
	
	private String name;
	private String surname;
	private int age;
	private String email;
	private String phoneNumber;
	private final String mode = "INSERT";
	
	public DataCustomerUserInsertView()
	{}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("DataCustomerUser", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci nome dell'utente:");
		name = getInput();
		System.out.println("Inserisci cognome dell'utente:");
		surname = getInput();
		System.out.println("Inserisci età dell'utente:");
		age= Integer.parseInt(getInput());
		System.out.println("Inserisci email dell'utente:");
		email = getInput();
		System.out.println("Inserisci numero di telefono dell'utente:");
		phoneNumber = getInput();
		System.out.println("Inserisci id dell'utente");
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("surname", surname);
		request.put("age", age);
		request.put("email", email);
		request.put("phoneNumber", phoneNumber);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("DataCustomerUser", "doControl", request);
		
	}
	
	
}
