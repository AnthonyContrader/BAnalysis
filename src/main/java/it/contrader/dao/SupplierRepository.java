package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Supplier;

@Repository
@Transactional
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
 	Supplier findByName(String name);
}
