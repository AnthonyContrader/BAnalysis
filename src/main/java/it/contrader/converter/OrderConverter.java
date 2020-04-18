package it.contrader.converter;

import java.util.*;

import it.contrader.dto.OrderDTO;
import it.contrader.model.Order;

public class OrderConverter {

	// Crea un oggetto di tipo OrderDTO e lo riempie coi parametri order di tipo
	// Order
	// Vogliamo trasformare un oggetto di tipo Order in tipo DTO

	public OrderDTO toDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO(order.getId(), order.getQuantity(), order.getOrderNumber(), order.getDate());
		return orderDTO;

	}

	// Crea un oggetto di tipo order e lo riempio coi parametri di tipo dto
	// tipo di ritorno Order
	public Order toEntity(OrderDTO orderDTO) {

		Order order = new Order(orderDTO.getId(), orderDTO.getQuantity(), orderDTO.getOrderNumber(),
				orderDTO.getDate());
		return order;

	}

	/*
	 * metodo per convertire le liste di Order in liste OrderDTO
	 */

	// metodo per aggiungere oggetto Order ad una lista orderDTOList
	public List<OrderDTO> convertToDTOList(List<Order> orderList) {

		List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();

		// for loop enhanced (foreach)
		for (Order o : orderList) {
			// aggiungo ciascun elemento di Order a orderDTOList
			orderDTOList.add(toDTO(o));
		}

		return orderDTOList;
	}

}
