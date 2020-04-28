package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.DataCustomerConverter;
import it.contrader.dao.DataCustomerRepository;
import it.contrader.dto.DataCustomerDTO;
import it.contrader.model.DataCustomer;

@Service
public class DataCustomerService extends AbstractService<DataCustomer, DataCustomerDTO> {
	
	@Autowired
	private DataCustomerConverter converter;
	@Autowired
	private DataCustomerRepository repository;

	public DataCustomerDTO findByNameAndSurname(String name, String surname) {
		return converter.toDTO(repository.findByNameAndSurname(name, surname));
	}
}
