package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Orders;

public interface OrdersDAO {
	
	public boolean saveOrUpdate(Orders orders);
	  public boolean update(Orders orders);
	  public boolean delete(Orders orders);
	  public Orders get(String id);
	  public List<Orders> list();
	  
       
}
