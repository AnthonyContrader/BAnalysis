package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.SupplierConverter;
import it.contrader.dao.SupplierRepository;
import it.contrader.dto.SupplierDTO;
import it.contrader.model.Supplier;

@Service
public class SupplierService extends AbstractService<Supplier, SupplierDTO> {

	@Autowired
	private SupplierConverter converter;
	@Autowired
	private SupplierRepository repository;
	

	public SupplierDTO findByName(String name) {
		return converter.toDTO(repository.findByName(name));
	}
	
	public Supplier findEntityByName(String name) {
		return converter.toEntity(converter.toDTO(repository.findByName(name)));
	}
	
	public List<SupplierDTO> getAllElements() {
		return converter.toDTOList(repository.findAll());
	}
}
