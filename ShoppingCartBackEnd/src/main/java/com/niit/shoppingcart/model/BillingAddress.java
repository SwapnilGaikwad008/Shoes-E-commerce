package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
public class BillingAddress implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
	@Id
	private String billingAddressId;
	
	@NotBlank(message="Specify main address")
	private String line1;
	

	@NotBlank(message="Specify city")
	private String city;
	
	@NotBlank(message="Specify state")
	private String state;
	
	@NotBlank(message="Specify Country")
	private String country;
	
	@NotBlank(message="Specify zipcode")
	private String zipcode;
	
	
	public String getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	

}
