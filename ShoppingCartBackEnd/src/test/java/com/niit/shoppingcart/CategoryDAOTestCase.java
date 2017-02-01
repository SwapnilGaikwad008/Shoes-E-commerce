package com.niit.shoppingcart;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

import junit.framework.Assert;



public class CategoryDAOTestCase {

	@Autowired
	static CategoryDAO categoryDAO;
	
	@Autowired
	static Category category;
	
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
		
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
		
	   System.out.println("User's BEAN CREATED");
	}
	
	@Test
	public void saveTestCase()
	{
		category = new Category();
		category.setId("3");
		category.setName("Nike");
		category.setDescription("Paris");
		
		
		Assert.assertEquals("saveTestCase", true, categoryDAO.save(category));
	}
	
}