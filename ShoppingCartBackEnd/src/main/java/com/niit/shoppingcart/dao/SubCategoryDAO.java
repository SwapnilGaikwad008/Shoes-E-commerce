package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.SubCategory;

public interface SubCategoryDAO {

	public List<SubCategory> list();

	public SubCategory get(String id);

	public  boolean save(SubCategory subCategory);
	
	public boolean update(SubCategory subCategory);

	public boolean delete(SubCategory subCategory);

}