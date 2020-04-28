package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.DataCustomer;

@Repository
@Transactional

public interface DataCustomerRepository extends CrudRepository<DataCustomer, Long> {
 DataCustomer findByNameAndSurname(String name, String surname);
}