package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.SupplierDTO;
import it.contrader.model.Supplier;

@Component
public class SupplierConverter extends AbstractConverter<Supplier, SupplierDTO> {

	@Override
	public Supplier toEntity(SupplierDTO supplierDTO) {
		Supplier supplier = null;
		if (supplierDTO != null) {
			supplier = new Supplier(supplierDTO.getId(), supplierDTO.getName(), supplierDTO.getCountry(), supplierDTO.getEmail());
		}
		return supplier;
	}

	@Override
	public SupplierDTO toDTO(Supplier supplier) {
		SupplierDTO supplierDTO = null;
		if (supplier != null) {
			supplierDTO = new SupplierDTO(supplier.getId(), supplier.getName(), supplier.getCountry(), supplier.getEmail());

		}
		return supplierDTO;
	}
}
