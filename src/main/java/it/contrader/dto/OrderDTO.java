package it.contrader.dto;

//import java.util.Date;

public class OrderDTO {
	
	private int id;
//	private String product;
//	private Product product;
	private int quantity;
	private String orderNumber;
	private String date;
	
	public OrderDTO() {
 	}

	public OrderDTO(int quantity, String orderNumber, String date) {
//		this.product = product;
		this.quantity = quantity;
		this.orderNumber = orderNumber;
		this.date = date;
	}

	public OrderDTO(int id, int quantity, String orderNumber, String date) {
		this.id = id;
//		this.product = product;
		this.quantity = quantity;
		this.orderNumber = orderNumber;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getProduct() {
//		return product;
//	}
//
//	public void setProduct(String product) {
//		this.product = product;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return id + "\t"  + quantity + "\t\t" + orderNumber + "\t\t" + date;
	}

	
	
}
