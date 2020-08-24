package com.wellsfargo.fsd.cpk.entity;

public class KitDetail {

	private int id;
	private String productName;
	private String productDesc;
	private int quantity;
	private double productCost;
	private double amount;
	
	public KitDetail() {
		super();
	}

	public KitDetail(int id, String productName, String productDesc, int quantity, double amount, double productCost) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDesc = productDesc;
		this.quantity = quantity;
		this.amount = amount;
		this.productCost=productCost;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
