package com.eval.coronakit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class CoronaKit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Delivery Address cannot be null")
	@NotBlank(message="Delivery Address cannot be blank")
	private String deliveryAddress;
	private String orderDate;
	private int totalAmount;
	public CoronaKit() {
		
	}

	public CoronaKit(int id, String deliveryAddress, String orderDate, int totalAmount) {
		super();
		this.id = id;
		this.deliveryAddress = deliveryAddress;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

}