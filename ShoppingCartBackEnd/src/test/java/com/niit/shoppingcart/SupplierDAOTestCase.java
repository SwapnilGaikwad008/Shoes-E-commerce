package com.niit.shoppingcart;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

import junit.framework.Assert;

public class SupplierDAOTestCase {
	
	@Autowired
	static SupplierDAO supplierDAO;
	
	@Autowired
	static Supplier supplier;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	//Previously we written constructor
	//But in Junit we need to write a method
	//this method should call automatically when JUnit Test case run
	
	@BeforeClass   //we can write @BeforeClasses only for the static methods
	public static void init()
	{
		context = new  AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
		
	   System.out.println("User's BEAN CREATED");
	}
	
	@Test
	public void saveTestCase()
	{
		supplier = new Supplier();
		supplier.setId("3");
		supplier.setName("Nike");
		supplier.setAddress("Paris");
		
		
		Assert.assertEquals("saveTestCase", true, supplierDAO.save(supplier));
	}
	
}
