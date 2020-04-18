package it.contrader.controller;

import java.util.List;

import it.contrader.dto.OrderDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.*;

public class OrderUserController implements Controller {

	// definisce il pacchetto di vista
	private static String sub_package = "orderuser.";
	private OrderService orderService;

	// Costruisce un oggetto di tipo Service per poterne usare i metodi
	public OrderUserController() {
		this.orderService = new OrderService();
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
		int  quantity;
		String  orderNumber;
		String  date;

		switch (mode) {
		
		// Arriva qui dalla ReadView. Invoca il Service con il parametro id e invia alla ReadView un elemento da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			OrderDTO orderDTO = orderService.read(id);
			request.put("order", orderDTO);
			MainDispatcher.getInstance().callView(sub_package + "OrderUserRead", request);
			break;
			
		// Arriva qui dalla InsertView.
		// Estrae i parametri da inserire e chiama il service per inserire un elemento con questi parametri
		case "INSERT":
			quantity    = Integer.parseInt(request.get("quantity").toString());
			orderNumber = request.get("orderNumber").toString();
			date   = request.get("date").toString();
				
			//costruisce l'oggetto user da inserire
			OrderDTO ordertoinsert = new OrderDTO(quantity, orderNumber, date);

			//invoca il service
			orderService.insert(ordertoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "OrderUserInsert", request);
			break;
			
		//Arriva qui dalla View, nvoca il Service e invia alla View il risultato da mostrare 
		case "ORDERLIST":
			List<OrderDTO> ordersDTO = orderService.getAll();

			//Impacchetta la request con la lista degli elementi
			request.put("orders", ordersDTO);
			MainDispatcher.getInstance().callView("OrderUser", request);
			break;
			
		// Esegue uno switch sulla base del comando inserito dall'utente e reindirizza
		// tramite il Dispatcher alla View specifica per ogni operazione
		// con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
			//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "OrderUserRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "OrderUserInsert", null);
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
