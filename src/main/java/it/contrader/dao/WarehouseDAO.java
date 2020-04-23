package it.contrader.dao;

import java.util.*;
import java.sql.*;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Warehouse;

public class WarehouseDAO implements DAO<Warehouse>{
	
	private final String QUERY_ALL = "SELECT * FROM warehouse";
	private final String QUERY_CREATE = "INSERT INTO warehouse (city,capacity) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM warehouse WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE warehouse SET city=?, capacity=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM warehouse WHERE id=?";

	
	public WarehouseDAO() {}
	
	/*restutuisco la lista dei magazzini*/
	public List<Warehouse> getAll() {
		List<Warehouse> warehouseList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Warehouse warehouse;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String city = resultSet.getString("city");
				int capacity = resultSet.getInt("capacity");
				warehouse = new Warehouse(city, capacity);
				warehouse.setId(id);
				warehouseList.add(warehouse);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return warehouseList;
	}	
	
	/*insert della warehouse*/
	public boolean insert(Warehouse warehouseToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, warehouseToInsert.getCity());
			preparedStatement.setInt(2, warehouseToInsert.getCapacity());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	
	public Warehouse read(int warehouseId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, warehouseId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String city;
			int capacity;
			
			city = resultSet.getString("city");
			capacity = resultSet.getInt("capacity");
			Warehouse warehouse = new Warehouse(city, capacity);
			warehouse.setId(resultSet.getInt("id"));
			
			return warehouse;
		} catch (SQLException e) {
			return null;
		}
	}

	
	public boolean update(Warehouse warehouseToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		//controllo sull'id
		if(warehouseToUpdate.getId() == 0) {
			return false;
		}
		//il magazzino da modificare esiste
		Warehouse warehouseRead = read(warehouseToUpdate.getId());
		if(!warehouseRead.equals(warehouseToUpdate)) {
			try {
				if(warehouseToUpdate.getCity() == null || warehouseToUpdate.getCity().equals("")) {
					warehouseToUpdate.setCity(warehouseRead.getCity());
				}
				if(warehouseToUpdate.getCapacity() <= 0 || (Integer)warehouseToUpdate.getCapacity() == null
						|| String.valueOf(warehouseToUpdate.getCapacity()).equals("")) {
					warehouseToUpdate.setCapacity(warehouseRead.getCapacity());
				}
				
				//Update magazzino
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, warehouseToUpdate.getCity());
				preparedStatement.setInt(2, warehouseToUpdate.getCapacity());
				preparedStatement.setInt(3, warehouseToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}		
		}
		
		return false;
	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
	
	
	
}
