package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.OrderSales;

@Repository
@Transactional
	
	public interface OrderRepository extends CrudRepository<OrderSales, Long>{
		//non ho bisogno di scrivere alcun che all'interno
	}




 
 
