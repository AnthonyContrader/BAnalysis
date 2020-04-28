package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.OrderDTO;
import it.contrader.model.OrderSales;

@Component
public class OrderConverter extends AbstractConverter<OrderSales, OrderDTO> {

	@Override
	public OrderSales toEntity(OrderDTO orderDTO) {
		OrderSales order = null;
		if (orderDTO != null) {
			order = new OrderSales(orderDTO.getId(), orderDTO.getQuantity(), orderDTO.getOrderNumber(),
					orderDTO.getDate());
		}
		return order;
	}

	@Override
	public OrderDTO toDTO(OrderSales order) {
		OrderDTO orderDTO = null;
		if (order != null) {
			orderDTO = new OrderDTO(order.getId(), order.getQuantity(), order.getOrderNumber(), order.getDate());

		}
		return orderDTO;
	}
}