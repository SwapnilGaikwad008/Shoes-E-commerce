package com.niit.shoppingcart;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

import junit.framework.Assert;

public class ProductDAOTestCase {

	@Autowired
	static ProductDAO productDAO;
	
	@Autowired
	static Product product;
	
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
		
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
		
	   System.out.println("User's BEAN CREATED");
	}
	
	@Test
	public void saveTestCase()
	{
		product = new Product();
		product.setId("3");
		product.setName("Jordan");
		product.setDescription("It's a Shoes");
		//product.setCategory_id("AirMax1");
		product.setSupplier_id("2");
	//	product.setPrice("10000");
		product.setStock("11");
		
		
		
		Assert.assertEquals("saveTestCase", true, productDAO.save(product));
	}
	

}
