package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.OrderConverter;
import it.contrader.dao.OrderRepository;  
import it.contrader.dto.OrderDTO;
import it.contrader.model.OrderSales;


@Service
public class OrderService extends AbstractService<OrderSales, OrderDTO>{
	
	@Autowired
	private OrderConverter converter;
	@Autowired
	private OrderRepository repository;
	
	//non ho bisogno di alcun metodo

}
