package it.contrader.controller;

import java.util.List;

import it.contrader.dto.SupplierDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.*;

public class SupplierUserController implements Controller {

	// definisce il pacchetto di vista
	private static String sub_package = "supplieruser.";
	private SupplierService supplierService;

	// Costruisce un oggetto di tipo Service per poterne usare i metodi
	public SupplierUserController() {
		this.supplierService = new SupplierService();
	}
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {

		// Estrae dalla request mode e choice
		String mode     = (String) request.get("mode");
		String choice   = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int     id;
		String  name;
		String  country;
		String  email;

		switch (mode) {
		
		// Arriva qui dalla ReadView. Invoca il Service con il parametro id e invia alla ReadView un elemento da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			SupplierDTO supplierDTO = supplierService.read(id);
			request.put("supplier", supplierDTO);
			MainDispatcher.getInstance().callView(sub_package + "SupplierUserRead", request);
			break;
			
		// Arriva qui dalla InsertView.
		// Estrae i parametri da inserire e chiama il service per inserire un elemento con questi parametri
		case "INSERT":
			name    = request.get("name").toString();
			country = request.get("country").toString();
			email   = request.get("email").toString();
				
			//costruisce l'oggetto user da inserire
			SupplierDTO suppliertoinsert = new SupplierDTO(name, country, email);

			//invoca il service
			supplierService.insert(suppliertoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "SupplierUserInsert", request);
			break;
/*			
		// Arriva qui dalla DeleteView. Estrae l'id dell'elemento da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());

			//Qui chiama il service
			supplierService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SupplierDelete", request);
			break;
			
		// Arriva qui dalla UpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name    = request.get("name").toString();
			country = request.get("country").toString();
			email   = request.get("email").toString();
			SupplierDTO suppliertoupdate = new SupplierDTO(name, country, email);
			suppliertoupdate.setID(id);
			supplierService.update(suppliertoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SupplierUpdate", request);
			break;
*/			
		//Arriva qui dalla View, nvoca il Service e invia alla View il risultato da mostrare 
		case "SUPPLIERLIST":
			List<SupplierDTO> suppliersDTO = supplierService.getAll();

			//Impacchetta la request con la lista degli elementi
			request.put("suppliers", suppliersDTO);
			MainDispatcher.getInstance().callView("SupplierUser", request);
			break;
			
		// Esegue uno switch sulla base del comando inserito dall'utente e reindirizza
		// tramite il Dispatcher alla View specifica per ogni operazione
		// con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
			//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "SupplierUserRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "SupplierUserInsert", null);
				break;
/*				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "SupplierUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "SupplierDelete", null);
				break;
*/				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeUser", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
