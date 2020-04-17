package it.contrader.view.supplier;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SupplierInsertView extends AbstractView {

	private Request request;
	private String name;
	private String country;
	private String email;
	private final String mode = "INSERT";

	public SupplierInsertView() {
	}

	// Se la request non � nulla (ovvero se si arriva dalla mode INSERT del controller) mostra l'esito dell'operazione
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Supplier", null);
		}
	}

	// Chiede all'utente di inserire gli attributi dell'utente da inserire
	@Override
	public void showOptions() {
			System.out.println("Inserisci il nome del fornitore:");
			name = getInput();
			System.out.println("Inserisci il paese del fornitore:");
			country = getInput();
			System.out.println("Inserisci la casella email del fornitore:");
			email = getInput();
	}

	// Impacchetta la request con i dati inseriti nel metodo showOption()
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("country", country);
		request.put("email", email);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Supplier", "doControl", request);
	}
}
