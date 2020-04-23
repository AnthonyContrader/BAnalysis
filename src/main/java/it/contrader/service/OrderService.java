package it.contrader.service;

//aggiungi i dao e converte appropriati
import it.contrader.converter.OrderConverter;
import it.contrader.dao.OrderDAO;
import it.contrader.dto.OrderDTO;
import it.contrader.model.Order;

public class OrderService extends AbstractService<Order, OrderDTO>{

//	private OrderDAO orderDAO;
//	private OrderConverter orderConverter;

	// costruttore che crea un oggetto di tipo DAO e uno di tipo Converter

	public OrderService() {
		this.dao = new OrderDAO();
		this.converter = new OrderConverter();
	}
	
}
