package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	public List<Product> list();
	
	public List<Product> listByCategoryAndSubCategory(String categoryId, String subCategoryId);

	public List<Product> getAll(); 
	
	public Product get(String id);

	public boolean save(Product product);

	public boolean update(Product product);
	
	public boolean delete(Product product);
	
	public List<String> productnames();

}
