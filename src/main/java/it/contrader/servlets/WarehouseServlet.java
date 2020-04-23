package it.contrader.servlets;

import java.util.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.WarehouseDTO;
import it.contrader.service.Service;
import it.contrader.service.WarehouseService;


public class WarehouseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public WarehouseServlet() {}
	
	public void updateList(HttpServletRequest request) {
		Service<WarehouseDTO> service = new WarehouseService();
		List<WarehouseDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<WarehouseDTO> service = new WarehouseService();
		String mode = request.getParameter("mode");
		WarehouseDTO dto;
		int id;
		boolean ans;
		
		//variabili che assieme ad id sono le istanze di Warehouse
		String city;
		int capacity;
		
		switch (mode.toUpperCase()) {
		
			case"WAREHOUSELIST":
				updateList(request);
				getServletContext().getRequestDispatcher("/warehouse/warehousemanager.jsp").forward(request, response);
				break;
				
			case "READ":
				id = Integer.parseInt(request.getParameter("id"));
				dto = service.read(id);
				request.setAttribute("dto", dto);
				
				if (request.getParameter("update") == null) {
					 getServletContext().getRequestDispatcher("/warehouse/readwarehouse.jsp").forward(request, response);	
				}
				else getServletContext().getRequestDispatcher("/warehouse/updatewarehouse.jsp").forward(request, response);
				break;
			
			case "INSERT":
				city = request.getParameter("city").toString();
				capacity = Integer.parseInt(request.getParameter("capacity").toString());
				dto = new WarehouseDTO (city,capacity);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/warehouse/warehousemanager.jsp").forward(request, response);
				break;
				
			case "UPDATE":
				city = request.getParameter("city");
				capacity = Integer.parseInt(request.getParameter("capacity"));
				id = Integer.parseInt(request.getParameter("id"));
				dto = new WarehouseDTO (id,city,capacity);
				ans = service.update(dto);
				updateList(request);
				getServletContext().getRequestDispatcher("/warehouse/warehousemanager.jsp").forward(request, response);
				break;

			case "DELETE":
				id = Integer.parseInt(request.getParameter("id"));
				ans = service.delete(id);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/warehouse/warehousemanager.jsp").forward(request, response);
				break;	
		}
	}
}
