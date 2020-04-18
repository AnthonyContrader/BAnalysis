package it.contrader.view.supplier;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SupplierUpdateView extends AbstractView {

	private Request request;
	private int id;
	private String name;
	private String country;
	private String email;
	private final String mode = "UPDATE";

	public SupplierUpdateView() {
	}

	// Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra l'esito dell'operazione
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Supplier", null);
		}
	}

	// Chiede all'utente di inserire gli attributi dell'elemento da modificare
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del fornitore:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome del fornitore:");
			name = getInput();
			System.out.println("Inserisci il paese del fornitore:");
			country = getInput();
			System.out.println("Inserisci la casella email del fornitore:");
			email = getInput();
		} catch (Exception e) {
			System.out.println("Errore nel salvataggio in memoria!");
		}
	}

	// Impacchetta la request con i dati inseriti nel metodo showOption()
	@Override
	public void submit() {
		// System.out.println("Inizio operazione di modifica...");
		request = new Request();
		request.put("id",       id);
		request.put("name",     name);
		request.put("country",  country);
		request.put("email",    email);
		request.put("mode",     mode);
		MainDispatcher.getInstance().callAction("Supplier", "doControl", request);
	}
}
