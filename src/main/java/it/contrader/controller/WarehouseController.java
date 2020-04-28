package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.WarehouseDTO;
import it.contrader.service.WarehouseService;


@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
	
	@Autowired
	private WarehouseService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "warehouses";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "warehouses";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatewarehouse";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id,
			@RequestParam("city") String city, @RequestParam("capacity") int capacity) {
		
		WarehouseDTO dto = new WarehouseDTO();
		dto.setId(id);
		dto.setCity(city);
		dto.setCapacity(capacity);
		service.update(dto);
		setAll(request);
		
		return "warehouses";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("city") String city, @RequestParam("capacity") int capacity) {
		
		WarehouseDTO dto = new WarehouseDTO();
		dto.setCity(city);
		dto.setCapacity(capacity);
		service.insert(dto);
		setAll(request);
		return "warehouses";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readwarehouse";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}

}
