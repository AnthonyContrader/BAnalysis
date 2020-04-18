package it.contrader.model;

//import java.util.Date;

public class Order {

	private int id;
//	private String product;
//	private Product product;
	private int quantity;
	private String orderNumber;
	private String date;

	public Order() {
	}

	public Order(int quantity, String orderNumber, String date) {
//		this.product = product;
		this.quantity = quantity;
		this.orderNumber = orderNumber;
		this.date = date;
	}

	public Order(int id, int quantity, String orderNumber, String date) {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", quantity=" + quantity + ", orderNumber=" + orderNumber + ", date=" + date + "]";
	}



 


}
