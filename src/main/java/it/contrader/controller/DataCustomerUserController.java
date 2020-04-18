package it.contrader.controller;
import java.util.List;

import it.contrader.dto.DataCustomerDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.DataCustomerService;
public class DataCustomerUserController implements Controller{
private static String sub_package = "datacustomeruser.";
	
	private DataCustomerService datacustomerService;
	
	public DataCustomerUserController()
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
			MainDispatcher.getInstance().callView(sub_package + "DataCustomerUserRead", request);
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
			MainDispatcher.getInstance().callView(sub_package + "DataCustomerUserInsert", request);
			break;
			
		case "DATACUSTOMERLIST":
			List<DataCustomerDTO> datacustomersDTO=datacustomerService.getAll();
			request.put("datacustomers", datacustomersDTO);
			MainDispatcher.getInstance().callView("DataCustomerUser", request);
			break;
			
		case "GETCHOICE":
			switch (choice.toUpperCase())
			{
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "DataCustomerUserRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DataCustomerUserInsert", null);
				break;
				
				
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
