package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {

	@Autowired
	 Category category;
	
	@Autowired
	 CategoryDAO categoryDAO;

	
	@RequestMapping("manage_category_remove")
	public String deleteCategory(@ModelAttribute("id") String id, Model model, HttpSession session )
	{
		category = categoryDAO.get(id);
		System.out.println(category);
		boolean flag = categoryDAO.delete(category);
		
		List<Category> categoryList = categoryDAO.list();
		session.setAttribute("CategoryList", categoryList);
		
		String msg="successfully";
		if(!flag==true)
			msg="not be success";
		return "forward:/categorytable";
	
		
		}
			

	@RequestMapping("manage_category_edit")
	public String editCategory(@ModelAttribute("id") String id, Model model, HttpSession session )
	{
		category = categoryDAO.get(id);
		model.addAttribute("category", category);	
		model.addAttribute("UserClickedEDIT", "true");
		return "admin";
		
	}
	
	@RequestMapping("/editcategory")
	public String AddCategory(Model model,HttpSession session,@ModelAttribute("id") String id, @ModelAttribute("name") String name,@ModelAttribute("description") String description)
	{
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		
		if(categoryDAO.update(category))
		{
			model.addAttribute("message", "Category updated");
		
		session.setAttribute("category", category);
		List<Category> categoryList = categoryDAO.list();
		session.setAttribute("CategoryList", categoryList);
		}
		else
		{
			 model.addAttribute("message","Error occured");
		model.addAttribute("EditCategory", "true");
		
		}		
		return "admin";
	}
	
}
	

	


