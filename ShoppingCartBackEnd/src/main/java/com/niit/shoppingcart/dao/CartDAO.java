package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;

public interface CartDAO {
	
	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean delete(int id);
	public Cart get(int id);
	public Long getTotalAmount(String userId);
	public List<Cart> getActiveByUser(String userId);


}
