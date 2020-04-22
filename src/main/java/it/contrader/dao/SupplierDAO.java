package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Supplier;

public class SupplierDAO implements DAO<Supplier> {
	private final String QUERY_ALL      = "SELECT * FROM supplier";
	private final String QUERY_CREATE   = "INSERT   INTO supplier (name, country, email) VALUES (?,?,?)";
	private final String QUERY_READ     = "SELECT * FROM supplier                                   WHERE id=?";
	private final String QUERY_UPDATE   = "UPDATE        supplier SET name=?, country=?, email=?    WHERE id=?";
	private final String QUERY_DELETE   = "DELETE   FROM supplier                                   WHERE id=?";

	public SupplierDAO () {
	}

	public List<Supplier> getAll() {
		List<Supplier> supplierList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Supplier supplier;
			while (resultSet.next()) {
				int    id       = resultSet.getInt("id");
				String name     = resultSet.getString("name");
				String country  = resultSet.getString("country");
				String email    = resultSet.getString("email");
				supplier        = new Supplier(id, name, country, email);
				supplierList.add(supplier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supplierList;
	}

	public boolean insert(Supplier supplierToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, supplierToInsert.getName());
			preparedStatement.setString(2, supplierToInsert.getCountry());
			preparedStatement.setString(3, supplierToInsert.getEmail());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Supplier read(int supplierId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, supplierId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int    id;
			String name, country, email;
			id      = resultSet.getInt("id");
			name    = resultSet.getString("name");
			country = resultSet.getString("country");
			email   = resultSet.getString("email");
			Supplier supplier = new Supplier(id, name, country, email);
			return supplier;

		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Supplier supplierToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (supplierToUpdate.getId() == 0)
			return false;

		Supplier supplierRead = read(supplierToUpdate.getId());
		if (!supplierRead.equals(supplierToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (supplierToUpdate.getName() == null || supplierToUpdate.getName().equals("")) {
					supplierToUpdate.setName(supplierRead.getName());
				}

				if (supplierToUpdate.getCountry() == null || supplierToUpdate.getCountry().equals("")) {
					supplierToUpdate.setCountry(supplierRead.getCountry());
				}

				if (supplierToUpdate.getEmail() == null || supplierToUpdate.getEmail().equals("")) {
					supplierToUpdate.setEmail(supplierRead.getEmail());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, supplierToUpdate.getName());
				preparedStatement.setString(2, supplierToUpdate.getCountry());
				preparedStatement.setString(3, supplierToUpdate.getEmail());
				preparedStatement.setInt   (4, supplierToUpdate.getId());
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
