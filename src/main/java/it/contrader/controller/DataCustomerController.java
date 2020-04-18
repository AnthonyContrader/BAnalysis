package it.contrader.controller;
import java.util.List;

import it.contrader.dto.DataCustomerDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.DataCustomerService;
public class DataCustomerController implements Controller {

	private static String sub_package = "datacustomer.";
	
	private DataCustomerService datacustomerService;
	
	public DataCustomerController()
	{
	this.datacustomerService = new DataCustomerService();
	}

	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		int id;
		String name;
		String surname;
		int age;
		String email;
		String phoneNumber;
		
		
		switch (mode)
		{	
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			DataCustomerDTO datacustomerDTO = datacustomerService.read(id);
			request.put("datacustomer", datacustomerDTO);
			MainDispatcher.getInstance().callView(sub_package + "DataCustomerRead", request);
		    break;
		    
		case "INSERT":
			name= request.get("name").toString();
			surname= request.get("surname").toString();
			age = Integer.parseInt(request.get("age").toString());
			email=request.get("email").toString();
			phoneNumber = request.get("phoneNumber").toString();
			
			DataCustomerDTO datacustomertoinsert = new DataCustomerDTO(name,surname,age,email,phoneNumber);
			datacustomerService.insert(datacustomertoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DataCustomerInsert", request);
			break;
			
		case "DELETE":
			id=Integer.parseInt(request.get("id").toString());
			datacustomerService.delete(id);
			request=new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DataCustomerDelete", request);
			break;
			
		case "UPDATE":
			id=Integer.parseInt(request.get("id").toString());
			name=request.get("name").toString();
			surname=request.get("surname").toString();
			age = Integer.parseInt(request.get("age").toString());
			email=request.get("email").toString();
			phoneNumber = request.get("phoneNumber").toString();
			DataCustomerDTO datacustomertoupdate = new DataCustomerDTO(name,surname,age,email, phoneNumber);
			datacustomertoupdate.setId(id);
			datacustomerService.update(datacustomertoupdate);
			request=new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DataCustomerUpdate", request);
			break;
			
		case "DATACUSTOMERLIST":
			List<DataCustomerDTO> datacustomersDTO=datacustomerService.getAll();
			request.put("datacustomers", datacustomersDTO);
			MainDispatcher.getInstance().callView("DataCustomer", request);
			break;
			
		case "GETCHOICE":
			switch (choice.toUpperCase())
			{
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "DataCustomerRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DataCustomerInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "DataCustomerUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "DataCustomerDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
	
	
}