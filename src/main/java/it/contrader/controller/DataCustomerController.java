package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.DataCustomerDTO;
import it.contrader.service.DataCustomerService;

@Controller
@RequestMapping("/datacustomer")
public class DataCustomerController {

	@Autowired
	private DataCustomerService service;

{
		
	}
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		System.out.println("<---------------------------------Voglio vedere tutti gli users--------------------------------------->");
		setAll(request);
		System.out.println("<-----------------------------------Ritorno a buon fine getAll()---------------------------------------->");
		return "datacustomers";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "datacustomers";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatedatacustomer";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id,
			@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") int age, @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber)
	{

		DataCustomerDTO dto = new DataCustomerDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setSurname(surname);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setPhoneNumber(phoneNumber);
		service.update(dto);
		setAll(request);
		return "datacustomers";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("age") int age, @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber) {
		DataCustomerDTO dto = new DataCustomerDTO();
		dto.setName(name);
		dto.setSurname(surname);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setPhoneNumber(phoneNumber);
		service.insert(dto);
		setAll(request);
		return "datacustomers";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readdatacustomer";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	
}
