package it.contrader.view.supplier;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SupplierDeleteView extends AbstractView {
	private Request request;
	private int id;
	private final String mode = "DELETE";

	public SupplierDeleteView() {
	}

	// Se la request non � nulla (ovvero se si arriva dalla mode DELETE del controller) mostra l'esito dell'operazione
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Supplier", null);
		}
	}

	// Chiede all'utente di inserire l'id dell'elemento da cancellare
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del fornitore:");
			id = Integer.parseInt(getInput());
	}

	// impacchetta la request con l'id dell'elemento da cancellare
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Supplier", "doControl", request);
	}
}
