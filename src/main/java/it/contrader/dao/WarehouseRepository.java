package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Warehouse;

@Repository
@Transactional

public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {
	/*
	 * Interfaccia che eredita da CrudRepository i metodi del DAO
	 * necessita metodi all'interno (vedi UserRepository) solo in caso
	 * di operazioni non standard legate alle CRUD.
	 *
	 * */
}
