package com.wellsfargo.fsd.cpk.model;

public class Product {

	private int id;
	private String productName;
	private Double productCost;
	private String productDescription;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, String productName, Double productCost, String productDescription) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCost = productCost;
		this.productDescription = productDescription;
	}
	public Integer getId() {
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
	public Double getProductCost() {
		return productCost;
	}
	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
}
