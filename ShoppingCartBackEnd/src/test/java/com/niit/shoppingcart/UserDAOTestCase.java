package com.niit.shoppingcart;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

import junit.framework.Assert;



public class UserDAOTestCase {

	//Autowired - DAO, DO, context
	
	
	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static User  user;
	
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
		
		
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
		
	   System.out.println("User's BEAN CREATED");
	}
	
	@Test
	public void updateTestCase() {
		user.setId("2");
		user.setName("king");
		user.setContact("12345689");
		user.setRole("ROLE_USER");
		user.setPassword("123");

		Assert.assertEquals("updateTestCase", true);
	}

	@Test
	public void validateCredentails()
	{
		user = userDAO.isValidUser("1", "niit");
		Assert.assertEquals("inValidateCredentials",null,user);
	}
	
	@Test
	public void inValidateCredentials()
	{
		user = userDAO.isValidUser("1", "abc");
		Assert.assertEquals("inValidateCredentials", null, user);
	}
	
	/*@Test
	public void updateTestCase()
	{
		user = new User();
		user.setId("1");
		user.setLast_name("niit");
		user.setFirst_name("niit");
		user.setPassword("niit");
		user.setMail_id("niit@123");
		user.setContact("123456789");
		user.setRole("ROLE_ADMIN");
		
		Assert.assertEquals("updateTestCase", true, userDAO.update(user));
	}*/
}