package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.OrderDTO;

import it.contrader.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {

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
			@RequestParam("date") String date) {

//		System.out.println("<------------------------------------------@PostMapping(\"/update\")---------------------------->");
		OrderDTO dto = new OrderDTO();
		dto.setId(id);
		dto.setQuantity(quantity);
		dto.setOrderNumber(orderNumber);
		dto.setDate(date);
		service.update(dto);
		setAll(request);
		return "orders";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("quantity") int quantity,
			@RequestParam("orderNumber") String orderNumber, @RequestParam("date") String date) {
		OrderDTO dto = new OrderDTO();
		dto.setQuantity(quantity);
		dto.setOrderNumber(orderNumber);
		dto.setDate(date);
		service.insert(dto);
		setAll(request);
		return "orders";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		System.out.println("@GetMapping(\"/read\")");
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
