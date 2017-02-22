package com.niit.shoppingcart.dao;


import java.util.List;

import com.niit.shoppingcart.model.User;

public interface UserDAO {

	public List<User> list();

	public User get(String id);

	public User isValidUser(String id, String password);

	public void saveOrUpdate(User user);

	public void delete(String id);
	
	public User getUserByName(String name);

}
