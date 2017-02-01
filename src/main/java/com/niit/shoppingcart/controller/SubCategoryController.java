package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.dao.SubCategoryDAO;
import com.niit.shoppingcart.model.SubCategory;

@Controller
public class SubCategoryController {

	@Autowired
	 SubCategory subCategory;
	
	@Autowired
	 SubCategoryDAO subCategoryDAO;

	
	
	@RequestMapping("manage_subcategory_remove")
	public String deleteCategory(@ModelAttribute("id") String id, Model model, HttpSession session )
	{
		subCategory = subCategoryDAO.get(id);
		System.out.println(subCategory);
		boolean flag = subCategoryDAO.delete(subCategory);
		
		List<SubCategory> categoryList = subCategoryDAO.list();
		session.setAttribute("SubCategoryList", categoryList);
		
		String msg="successfully";
		if(!flag==true)
			msg="not be success";
		return "forward:/subcategorytable";
	
		
		}
			

	@RequestMapping("manage_subcategory_edit")
	public String editCategory(@ModelAttribute("id") String id, Model model, HttpSession session )
	{
		subCategory = subCategoryDAO.get(id);
		model.addAttribute("subcategory", subCategory);	
		model.addAttribute("UserClickedSubCategoryEDIT", "true");
		return "admin";
		
	}
	
	@RequestMapping("/editsubcategory")
	public String AddCategory(Model model,HttpSession session,@ModelAttribute("id") String id, @ModelAttribute("name") String name,@ModelAttribute("description") String description)
	{
		subCategory.setId(id);
		subCategory.setName(name);
		subCategory.setDescription(description);
		
		if(subCategoryDAO.update(subCategory))
		{
			model.addAttribute("message", "SubCategory updated");
		
		session.setAttribute("subcategory", subCategory);
		List<SubCategory> categoryList = subCategoryDAO.list();
		session.setAttribute("SubCategoryList", categoryList);
		}
		else
		{
			 model.addAttribute("message","Error occured");
		}		
		model.addAttribute("EditSubCategory", "true");
		return "admin";
	}
	
}