package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.SupplierDTO;
import it.contrader.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "suppliers";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "suppliers";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatesupplier";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request,
			@RequestParam("id")         Long id,
			@RequestParam("name")       String name, 
			@RequestParam("country")    String country,
			@RequestParam("email")      String email) {

		SupplierDTO dto = new SupplierDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setCountry(country);
		dto.setEmail(email);
		service.update(dto);
		setAll(request);
		return "suppliers";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
			@RequestParam("name")       String name,
			@RequestParam("country")    String country, 
			@RequestParam("email")      String email) {
		SupplierDTO dto = new SupplierDTO();
		dto.setName(name);
		dto.setCountry(country);
		dto.setEmail(email);
		service.insert(dto);
		setAll(request);
		return "suppliers";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readsupplier";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}

