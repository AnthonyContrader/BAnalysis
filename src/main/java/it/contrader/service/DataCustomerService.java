package it.contrader.service;

import java.util.*;

import it.contrader.converter.DataCustomerConverter;
import it.contrader.dao.DataCustomerDAO;
import it.contrader.dto.DataCustomerDTO;

public class DataCustomerService {
	private DataCustomerDAO datacustomerDAO;
	private DataCustomerConverter datacustomerConverter;
	
	//Istanzio DAO  e Converter specifici.
	public DataCustomerService(){
		this.datacustomerDAO = new DataCustomerDAO();
		this.datacustomerConverter = new DataCustomerConverter();
	}
	

	public List<DataCustomerDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return (List<DataCustomerDTO>) datacustomerConverter.toDTOList( datacustomerDAO.getAll());
	}


	public DataCustomerDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return datacustomerConverter.toDTO(datacustomerDAO.read(id));
	}


	public boolean insert(DataCustomerDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return datacustomerDAO.insert(datacustomerConverter.toEntity(dto));
	}


	public boolean update(DataCustomerDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return datacustomerDAO.update(datacustomerConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return datacustomerDAO.delete(id);
	}
	

}
