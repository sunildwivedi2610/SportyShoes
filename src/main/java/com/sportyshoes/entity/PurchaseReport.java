package com.sportyshoes.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class PurchaseReport {
	
	@Id
	@GeneratedValue
	private int id;
	private String purchasedBy;
	private String category;
	private Date dateOfPurchase;
	private String orderList;
	
	public PurchaseReport(String purchasedBy, String category, Date dateOfPurchase, String orderList) {
		super();
		this.purchasedBy = purchasedBy;
		this.category = category;
		this.dateOfPurchase = dateOfPurchase;
		this.orderList = orderList;
	}

	public int getId() {
		return id;
	}

	public String getPurchasedBy() {
		return purchasedBy;
	}

	public void setPurchasedBy(String purchasedBy) {
		this.purchasedBy = purchasedBy;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getOrderList() {
		return orderList;
	}

	public void setOrderList(String orderList) {
		this.orderList = orderList;
	}
	
	
}
