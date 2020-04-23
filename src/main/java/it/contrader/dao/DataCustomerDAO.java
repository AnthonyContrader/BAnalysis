package it.contrader.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.DataCustomer;

public class DataCustomerDAO implements DAO<DataCustomer> {
	private final String QUERY_ALL      = "SELECT * FROM db_banalysis.datacustomer";
	private final String QUERY_CREATE   = "INSERT   INTO datacustomer (name, surname, age, email, phoneNumber) VALUES (?,?,?,?,?)";
	private final String QUERY_READ     = "SELECT * FROM db_banalysis.datacustomer WHERE id=?";
	private final String QUERY_UPDATE   = "UPDATE db_banalysis.datacustomer SET name=?, surname=?, age=?, email=?, phoneNumber=? WHERE id=?";
	private final String QUERY_DELETE   = "DELETE FROM db_banalysis.datacustomer WHERE id=?";

	public DataCustomerDAO () {
	}

	public List<DataCustomer> getAll() {
		List<DataCustomer> datacustomerList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			DataCustomer datacustomer;
			while (resultSet.next()) {
				String name     = resultSet.getString("name");
				String surname  = resultSet.getString("surname");
				int age = resultSet.getInt("age");
				String email    = resultSet.getString("email");
				String phoneNumber = resultSet.getString("phoneNumber");
				int    id       = resultSet.getInt("id");
				datacustomer        = new DataCustomer(name, surname, age, email, phoneNumber);
				datacustomer.setId(id);
				datacustomerList.add(datacustomer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datacustomerList;
	}

	public boolean insert(DataCustomer datacustomerToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, datacustomerToInsert.getName());
			preparedStatement.setString(2, datacustomerToInsert.getSurname());
			preparedStatement.setInt(3, datacustomerToInsert.getAge());
			preparedStatement.setString(4, datacustomerToInsert.getEmail());
			preparedStatement.setString(5, datacustomerToInsert.getPhoneNumber());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public DataCustomer read(int datacustomerId) {
		
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, datacustomerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int age;
			String name, surname, email, phoneNumber;
			name    = resultSet.getString("name");
			surname = resultSet.getString("surname");
			age      = resultSet.getInt("age");
			email   = resultSet.getString("email");
			phoneNumber   = resultSet.getString("phoneNumber");
			DataCustomer datacustomer = new DataCustomer(name, surname, age, email, phoneNumber);
			datacustomer.setId(resultSet.getInt("id"));
			return datacustomer;

		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(DataCustomer datacustomerToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (datacustomerToUpdate.getId() == 0)
			return false;

		DataCustomer datacustomerRead = read(datacustomerToUpdate.getId());
	if (!datacustomerRead.equals(datacustomerToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (datacustomerToUpdate.getName() == null || datacustomerToUpdate.getName().equals("")) {
					datacustomerToUpdate.setName(datacustomerRead.getName()); 
					
				}

				if (datacustomerToUpdate.getSurname() == null || datacustomerToUpdate.getSurname().equals("")) {
					datacustomerToUpdate.setSurname(datacustomerRead.getSurname());
				}
				
				if (datacustomerToUpdate.getAge() <= 0 || (Integer)datacustomerToUpdate.getAge() == null|| String.valueOf(datacustomerToUpdate.getAge()).equals("")) {
					datacustomerToUpdate.setAge(datacustomerRead.getAge());
				}

				if (datacustomerToUpdate.getEmail() == null || datacustomerToUpdate.getEmail().equals("")) {
					datacustomerToUpdate.setEmail(datacustomerRead.getEmail());
				}
				
				if (datacustomerToUpdate.getPhoneNumber() == null || datacustomerToUpdate.getPhoneNumber().equals("")) {
					datacustomerToUpdate.setPhoneNumber(datacustomerRead.getPhoneNumber());
				}
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, datacustomerToUpdate.getName());
				preparedStatement.setString(2, datacustomerToUpdate.getSurname());
				preparedStatement.setInt   (3, datacustomerToUpdate.getAge());
				preparedStatement.setString(4, datacustomerToUpdate.getEmail());
				preparedStatement.setString(5, datacustomerToUpdate.getPhoneNumber());
				preparedStatement.setInt   (6, datacustomerToUpdate.getId());
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
