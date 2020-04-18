package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	
//	Codice nuovo
	
	private Request request;

	// Se la request non è nulla mostra un messaggio di benvenuto
	@Override
    public void showResults(Request request) {
    	if(request!=null) {
    		System.out.println("\n Benvenuto in SAMPLE PROJECT "+request.get("username").toString() + "\n");
    	}
    	else {
    		System.out.println("\n Benvenuto in SAMPLE PROJECT \n");

    	}
    }
    
	// Chiede all'utente di effettuare una scelta (da console)
	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println(" Seleziona cosa vuoi gestire:");
		System.out.println("[O]rdini  [E]sci");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() è definito in AbstractView.
		choice = this.getInput();
	}

	// Impacchetta una request (in base alla scelta sarà diversa) che invia ai controller tramite il Dispatcher
	@Override
	public void submit() {
    	//crea una nuova Request (vedi classe Request)
    	request = new Request();
		switch (choice) {
        case "o":
        	this.request.put("mode", "ORDERLIST");
        	MainDispatcher.getInstance().callAction("OrderUser", "doControl", request);
        	break;
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;
		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}


}
