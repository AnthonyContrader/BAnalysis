package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.OrderDTO;
import it.contrader.dto.SupplierDTO;
import it.contrader.model.Supplier;
//import it.contrader.model.User.Usertype;
import it.contrader.service.OrderService;
import it.contrader.service.SupplierService;
import it.contrader.converter.*;
import it.contrader.converter.SupplierConverter;
import it.contrader.dao.SupplierRepository;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;

	@Autowired
	private SupplierService serviceSupplier;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		
		// ho messo una variabile globale per supplier
		List<SupplierDTO> supplierListDTO;
		supplierListDTO = serviceSupplier.getAllElements();
		request.getSession().setAttribute("supplierList", supplierListDTO);

		setAll(request);

		return "orders";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "orders";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateorder";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id,
			@RequestParam("quantity") int quantity, @RequestParam("orderNumber") String orderNumber,
			@RequestParam("date") String date, 
			@RequestParam("name_of_supplier") String supplier_name) {

		OrderDTO dto = new OrderDTO();
		Supplier supplier = new Supplier();
		supplier = serviceSupplier.findEntityByName(supplier_name);
		dto.setId(id);
		dto.setQuantity(quantity);
		dto.setOrderNumber(orderNumber);
		dto.setDate(date);
		dto.setSupplier(supplier);
		service.update(dto);
		setAll(request);
		return "orders";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("quantity") int quantity,
			@RequestParam("orderNumber") String orderNumber, @RequestParam("date") String date, 
			@RequestParam("name_of_supplier") String supplier_name) {
		
		OrderDTO dto = new OrderDTO();
		Supplier supplier = new Supplier();
		supplier = serviceSupplier.findEntityByName(supplier_name);
		System.out.println("chi e' il supplier " + supplier);
		System.out.println("supplier.getCountry() " + supplier.getCountry());
		dto.setQuantity(quantity);
		dto.setOrderNumber(orderNumber);
		dto.setDate(date);
		dto.setSupplier(supplier);
		service.insert(dto);
		setAll(request);
		return "orders";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readorder";
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
