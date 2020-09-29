package com.eval.coronakit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KitDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int coronaKitId;
	
	@Column
	private int productId;
	
	@Column
	private String productName;

	@Column
	private int quantity;
	
	@Column
	private int amount;

	public KitDetail() {
		
	}

	public KitDetail(int coronaKitId, int productId, String productName, int quantity, int amount) {
		this.coronaKitId = coronaKitId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCoronaKitId() {
		return coronaKitId;
	}

	public void setCoronaKitId(int coronaKitId) {
		this.coronaKitId = coronaKitId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productFullName) {
		this.productName = productFullName;
	}

}
