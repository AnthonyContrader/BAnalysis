package it.contrader.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name="order_sales")
public class OrderSales {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id")
	private Long id;

	@Column(name="quantity")
	private int quantity;

	@Column(name="order_number")
	private String orderNumber;
	private String date;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	

	
	
}
