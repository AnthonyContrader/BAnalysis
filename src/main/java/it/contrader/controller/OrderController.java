package it.contrader.controller;

import java.util.List;

import it.contrader.dto.OrderDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.OrderService;

public class OrderController implements Controller {

	/*
	 * Definizione del pacchetto di vista order
	 */
	private static String sub_package = "order.";

	// creo un oggetto OrderService in modo da poterne utilizzare i metodi
	private OrderService orderService;

	public OrderController() {
		this.orderService = new OrderService();
	}

	// metodo implementato dall'interfaccia controller
	@Override
	public void doControl(Request request) {
//		System.out.println("Sono nell'OrderControl");
		// estraggo dalla request mode e choice
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		// definisco i campi della classe
		int id;
		int quantity;
		String orderNumber;
		String date;

//		System.out.println(mode);
//		System.out.println(choice);

		switch (mode) {
//System.out.println("Sono nell'OrderControl");

		// arriva qui dalla OrderReadReview. Invoco il service con il parametro id ed
		// invia a OrderReadreview uno order da mostrare
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			OrderDTO orderDTO = orderService.read(id);
			request.put("order", orderDTO);
			MainDispatcher.getInstance().callView(sub_package + "OrderRead", request);
			break;

		// arriva qui dalla OrderInsertView. Estraggo i parametri che voglio inserire e
		// posso inserire un order con questi parametri
		case "INSERT":
			quantity = Integer.parseInt(request.get("quantity").toString());
			orderNumber = request.get("orderNumber").toString();
			date = request.get("date").toString();

			// costruisco l'oggetto order
			OrderDTO ordertoinsert = new OrderDTO(quantity, orderNumber, date);

			// invoca il service
			orderService.insert(ordertoinsert);
			request = new Request();
			request.put("mode", "mode");

			// Vengo rimandato
			MainDispatcher.getInstance().callView(sub_package + "OrderInsert", request);
			break;

		// Arriva qui dalla OrderDeleteView. Estrae l'id dell'utente da cancellare e lo
		// passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			// Qui chiama il service
			orderService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "OrderDelete", request);
			break;

		// Arriva qui dalla OrderUpdateView
		case "UPDATE":
			System.out.println("Sono nell'update");
			id = Integer.parseInt(request.get("id").toString());
			quantity = Integer.parseInt(request.get("quantity").toString());
			orderNumber = request.get("orderNumber").toString();
			date = request.get("date").toString();
			OrderDTO orderToUpdate = new OrderDTO(quantity, orderNumber, date);
			orderToUpdate.setId(id);
			orderService.update(orderToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "OrderUpdate", request);
			break;

		// arrivo qua dalla orderView
		case "ORDERLIST":
			System.out.println("order list");
			List<OrderDTO> ordersDTO = orderService.getAll();
			// Impacchetta la request con la lista degli order
            //			request = new Request();
		
			request.put("orders", ordersDTO);
			MainDispatcher.getInstance().callView("Order", request);
 			break;

		case "GETCHOICE":
			// ho uno switch nello switch, tramite il Dispatcher alla viewper ogni
			// operazione
			// toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {

			case "L":
				MainDispatcher.getInstance().callView(sub_package + "OrderRead", null);
				break;

			case "I":
				MainDispatcher.getInstance().callView(sub_package + "OrderInsert", null);
				break;

			case "M":
				MainDispatcher.getInstance().callView(sub_package + "OrderUpdate", null);
				break;

			case "C":
				MainDispatcher.getInstance().callView(sub_package + "OrderDelete", null);
				break;

			case "E":
				MainDispatcher.getInstance().callView("Order", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;

			default:
//				System.out.println("Sono nel primo default");
				MainDispatcher.getInstance().callView("Order", null);

			}

		default:
//			System.out.println("Sono nel secondo default");
			MainDispatcher.getInstance().callView("Order", null);
		}
	}
}
