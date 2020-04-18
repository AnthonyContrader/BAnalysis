package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Order;
 

public class OrderDAO {

	private final String QUERY_ALL = "SELECT * FROM db_banalysis.order";
	private final String QUERY_CREATE = "INSERT INTO db_banalysis.order (quantity, orderNumber, date) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM db_banalysis.order WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE db_banalysis.order SET quantity=?, orderNumber=?, date=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM db_banalysis.order WHERE id=?";

	public OrderDAO() {

	}

	public List<Order> getAll() {
		List<Order> ordersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Order order;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int quantity = resultSet.getInt("quantity");
				String orderNumber = resultSet.getString("orderNumber");
				String date = resultSet.getString("date");
				order = new Order(quantity, orderNumber, date);
				order.setId(id);
				ordersList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	public boolean insert(Order orderToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, orderToInsert.getQuantity());
			preparedStatement.setString(2, orderToInsert.getOrderNumber());
			preparedStatement.setString(3, orderToInsert.getDate());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Order read(int orderId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int quantity;
			String orderNumber;
			String date;
			

			quantity = resultSet.getInt("quantity");
			orderNumber = resultSet.getString("orderNumber");
			date = resultSet.getString("date");
			Order order = new Order(quantity, orderNumber, date);
			order.setId(resultSet.getInt("id"));

			return order;
			
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Order orderToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (orderToUpdate.getId() == 0)
			return false;

		Order orderRead = read(orderToUpdate.getId());
		if (!orderRead.equals(orderToUpdate)) {
			try {
				// Fill the userToUpdate object
				
			
				if ((Integer)orderToUpdate.getQuantity() < 0 ||(Integer)orderToUpdate.getQuantity() == null) {
					orderToUpdate.setQuantity(orderRead.getQuantity());
				}

				if (orderToUpdate.getOrderNumber() == null || orderToUpdate.getOrderNumber().equals("")) {
					orderToUpdate.setOrderNumber(orderRead.getOrderNumber()); 
				}

				if (orderToUpdate.getDate() == null || orderToUpdate.getDate().equals("")) {
					orderToUpdate.setDate(orderRead.getDate());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, orderToUpdate.getQuantity());
				preparedStatement.setString(2, orderToUpdate.getOrderNumber());
				preparedStatement.setString(3, orderToUpdate.getDate());
				preparedStatement.setInt(4, orderToUpdate.getId());
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
		//cancella l'ordine con l'id
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
