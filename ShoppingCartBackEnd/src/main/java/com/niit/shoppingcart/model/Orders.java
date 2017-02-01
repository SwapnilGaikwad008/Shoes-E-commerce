package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")    //Optional if the table name is same as class name
@Component

	public class Orders implements Serializable {
		private static final long serialVersionUID= 1L;

		@Id
		@Column(name="Orders_id")
		private int id;
		

		@Column(name="user_id")
		private String user_id;
		
		@Column(name="cart_id")//Optional if the property name in this class is same as field name in the table
		private int cartId;
		
		@Column(name="billing_address")
		private BillingAddress billingAddress;
		
		@Column(name="shipping_address")
		private ShippingAddress shippingAddress;
		
		@Column(name="payment_method")
		private String paymentMethod;
	    
		private int totalAmount;

		
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

		public int getCartId() {
			return cartId;
		}

		public void setCartId(int cartId) {
			this.cartId = cartId;
		}

		public BillingAddress getBillingAddress() {
			return billingAddress;
		}

		public void setBillingAddress(BillingAddress billingAddress) {
			this.billingAddress = billingAddress;
		}

		public ShippingAddress getShippingAddress() {
			return shippingAddress;
		}

		public void setShippingAddress(ShippingAddress shippingAddress) {
			this.shippingAddress = shippingAddress;
		}

		public String getPaymentMethod() {
			return paymentMethod;
		}

		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}

		public int getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(int totalAmount) {
			this.totalAmount = totalAmount;
		}

		

		
		

}
