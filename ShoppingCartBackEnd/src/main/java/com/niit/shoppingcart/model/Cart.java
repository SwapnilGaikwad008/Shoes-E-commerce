package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "cart")
@Component

public class Cart implements Serializable{

	private static final long serialVersionUID = 2183210161066479796L;

	
	@Id
	@Column(name = "cart_id")
	private int id;
	
	@Column(name = "user_id")
	private String user_id;
	
	@Column(name = "product_name")
	private String  productName;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "stock")
	private int stock ;
	

	@Column(name = "ordered")
	private int ordered;
	
	public int getOrdered() {
		return ordered;
	}

	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
