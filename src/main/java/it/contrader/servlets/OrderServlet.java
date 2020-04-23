package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.OrderDTO;
import it.contrader.service.OrderService;
import it.contrader.service.Service;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderServlet() {
	}

	public void updateList(HttpServletRequest request) {
		Service<OrderDTO> service = new OrderService();
		List<OrderDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<OrderDTO> service = new OrderService();
		String mode = request.getParameter("mode");
		OrderDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

			case "ORDERLIST":
				updateList(request);
				getServletContext().getRequestDispatcher("/order/ordermanager.jsp").forward(request, response);
				break;
	
			case "READ":
				id = Integer.parseInt(request.getParameter("id"));
				dto = service.read(id);
				request.setAttribute("dto", dto);
	
				if (request.getParameter("update") == null) {
					getServletContext().getRequestDispatcher("/order/readorder.jsp").forward(request, response);
	
				}
	
				else
					getServletContext().getRequestDispatcher("/order/updateorder.jsp").forward(request, response);
	
				break;
	
			case "INSERT":
				int quantity = Integer.parseInt(request.getParameter("quantity").toString());
				String orderNumber = request.getParameter("orderNumber").toString();
				String date = request.getParameter("date").toString();
				dto = new OrderDTO(quantity, orderNumber, date);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/order/ordermanager.jsp").forward(request, response);
				break;
	
			case "UPDATE":
				quantity = Integer.parseInt(request.getParameter("quantity"));
				orderNumber = request.getParameter("orderNumber");
				date = request.getParameter("date");
				id = Integer.parseInt(request.getParameter("id"));
				dto = new OrderDTO(id, quantity, orderNumber, date);
				ans = service.update(dto);
				updateList(request);
				getServletContext().getRequestDispatcher("/order/ordermanager.jsp").forward(request, response);
				break;
	
			case "DELETE":
				id = Integer.parseInt(request.getParameter("id"));
				ans = service.delete(id);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/order/ordermanager.jsp").forward(request, response);
				break;
		}
	}

}
