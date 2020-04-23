package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.SupplierDTO;
import it.contrader.service.Service;
import it.contrader.service.SupplierService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupplierServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<SupplierDTO> service = new SupplierService();
		List<SupplierDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<SupplierDTO> service = new SupplierService();
		String mode = request.getParameter("mode");
		SupplierDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {
			case "SUPPLIERLIST":
				updateList(request);
				getServletContext().getRequestDispatcher("/supplier/suppliermanager.jsp").forward(request, response);
				break;
		
			case "READ":
				id  = Integer.parseInt(request.getParameter("id"));
				dto = service.read(id);
				request.setAttribute("dto", dto);
				
				if (request.getParameter("update") == null) {
					 getServletContext().getRequestDispatcher("/supplier/readsupplier.jsp").forward(request, response);
					
				}
				
				else getServletContext().getRequestDispatcher("/supplier/updatesupplier.jsp").forward(request, response);
				
				break;
		
			case "INSERT":
				String name     = request.getParameter("name").toString();
				String country  = request.getParameter("country").toString();
				String email    = request.getParameter("email").toString();
				dto = new SupplierDTO (name, country, email);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/supplier/suppliermanager.jsp").forward(request, response);
				break;
				
			case "UPDATE":
				name    = request.getParameter("name");
				country = request.getParameter("country");
				email   = request.getParameter("email");
				id  = Integer.parseInt(request.getParameter("id"));
				dto = new SupplierDTO (id, name, country, email);
				ans = service.update(dto);
				updateList(request);
				getServletContext().getRequestDispatcher("/supplier/suppliermanager.jsp").forward(request, response);
				break;
		
			case "DELETE":
				id  = Integer.parseInt(request.getParameter("id"));
				ans = service.delete(id);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/supplier/suppliermanager.jsp").forward(request, response);
				break;
}
	}
}