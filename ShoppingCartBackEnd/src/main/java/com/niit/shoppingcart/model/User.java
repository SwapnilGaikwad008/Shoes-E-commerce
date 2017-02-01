package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//map to specific database entity (Table)
//Which table you have map
//Create Singleton instance/object

@Entity
@Table    //if the table name and domain object name is same
@Component     //user instance       // do not use User u = new User()
public class User   implements Serializable{
	
	
	//what are the properties  same as db table fields
	@Id     //To specify this field is primary key
	private String id;
	
	private String name;
	
	private String password;
	
	private String mail;
	
	private String contact;
	
	
	private String role;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	

}