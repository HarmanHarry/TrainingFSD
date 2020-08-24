package com.wellsfargo.fsd.cpk.entity;

import java.util.List;

public class OrderSummary {

	private User user;
	private List<KitDetail> kitDetails;
	private Double totalCost;
	
	
	public OrderSummary(User user, List<KitDetail> kitDetails, Double totalCost) {
		super();
		this.user = user;
		this.kitDetails = kitDetails;
		this.totalCost = totalCost;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<KitDetail> getKitDetails() {
		return kitDetails;
	}
	public void setKitDetails(List<KitDetail> kitDetails) {
		this.kitDetails = kitDetails;
	}
	public OrderSummary() {
		super();
	}
	
	
	
}
