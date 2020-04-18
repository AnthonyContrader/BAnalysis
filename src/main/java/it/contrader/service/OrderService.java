package it.contrader.service;

import it.contrader.dao.OrderDAO;
import it.contrader.dto.OrderDTO;
import it.contrader.converter.OrderConverter;
import java.util.*;

public class OrderService {

	private OrderDAO orderDAO;
	private OrderConverter orderConverter;

	// costruttore che crea un oggetto di tipo DAO e uno di tipo Converter

	public OrderService() {
		this.orderDAO = new OrderDAO();
		this.orderConverter = new OrderConverter();
	}

	// ottengo una lista di entita e le converto in DTO
	public List<OrderDTO> getAll() {

		return orderConverter.convertToDTOList(orderDAO.getAll());
	}
	
	//ottengo un'entita id e la converto in DTO
	public OrderDTO read(int id) {
		return orderConverter.toDTO(orderDAO.read(id));
	}
	
	//insert
	public boolean insert(OrderDTO dto) {
		return orderDAO.insert(orderConverter.toEntity(dto));

	}
	
	//update
	public boolean update(OrderDTO dto) {
		// Converte un OrderDTO in entita e lo passa allo orderDAO per la modifica
		return orderDAO.update(orderConverter.toEntity(dto));
	}
	
	//delete
	
	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return orderDAO.delete(id);
	}

}
