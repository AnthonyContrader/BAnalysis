package it.contrader.service;

import java.util.List;

import it.contrader.converter.SupplierConverter;
import it.contrader.dao.SupplierDAO;
import it.contrader.dto.SupplierDTO;

public class SupplierService {

	private SupplierDAO supplierDAO;
	private SupplierConverter supplierConverter;

	//Istanzio DAO  e Converter specifici.
	public SupplierService() {
		this.supplierDAO = new SupplierDAO();
		this.supplierConverter = new SupplierConverter();
	}
	public List<SupplierDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return supplierConverter.toDTOList(supplierDAO.getAll());
	}
	public SupplierDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return supplierConverter.toDTO(supplierDAO.read(id));
	}
	public boolean insert(SupplierDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return supplierDAO.insert(supplierConverter.toEntity(dto));
	}
	public boolean update(SupplierDTO dto) {
		// Converte un SupplierDTO in entità e lo passa al supplierDAO per la modifica
		return supplierDAO.update(supplierConverter.toEntity(dto));
	}
	public boolean delete(int id) {
		// Questo metodo chiama direttamente il DAO
		return supplierDAO.delete(id);
	}

}
