package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.DataCustomerDTO;
import it.contrader.service.Service;
import it.contrader.service.DataCustomerService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class DataCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DataCustomerServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<DataCustomerDTO> service = new DataCustomerService();
		List<DataCustomerDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<DataCustomerDTO> service = new DataCustomerService();
		String mode = request.getParameter("mode");
		DataCustomerDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "DATACUSTOMERLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/datacustomer/datacustomermanager.jsp").forward(request, response);
			break;


		case "READ":
			id  = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/datacustomer/readdatacustomer.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/datacustomer/updatedatacustomer.jsp").forward(request, response);
			
			break;


		case "INSERT":
			String name     = request.getParameter("name").toString();
			String surname  = request.getParameter("surname").toString();
			int age =Integer.parseInt(request.getParameter("age").toString());
			String email    = request.getParameter("email").toString();
			String phoneNumber = request.getParameter("phoneNumber").toString();
			dto = new DataCustomerDTO (name, surname, age, email, phoneNumber);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/datacustomer/datacustomermanager.jsp").forward(request, response);
			break;
			
			
		case "UPDATE":
			name    = request.getParameter("name");
			surname = request.getParameter("surname");
			age = Integer.parseInt(request.getParameter("age"));
			email   = request.getParameter("email");
			phoneNumber = request.getParameter("phoneNumber");
			id  = Integer.parseInt(request.getParameter("id"));
			dto = new DataCustomerDTO (name, surname, age, email, phoneNumber, id);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/datacustomer/datacustomermanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id  = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/datacustomer/datacustomermanager.jsp").forward(request, response);
			break;
		}
	}
}
