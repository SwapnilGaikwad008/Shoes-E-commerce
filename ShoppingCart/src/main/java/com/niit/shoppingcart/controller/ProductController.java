package com.niit.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.util.Util;

@Controller
public class ProductController {

	@Autowired
	Product product;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Category category;

	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private Cart cart;
	private String path = "D:\\workspace\\ShoppingCart\\src\\main\\webapp\\resources\\img";
	
	public ProductController() {

	}

	@RequestMapping("manage_product_remove")
	public String DeleteProduct(@ModelAttribute("id") String id, Model model, HttpSession session) {
		product = productDAO.get(id);
		System.out.println(product);
		boolean flag = productDAO.delete(product);
		List<Product> productList = productDAO.list();
		session.setAttribute("ProductList", productList);
		String msg = "successfully done";
		if (!flag == true)
			msg = "Not successful";
		return "forward:/producttable";

	}

	@RequestMapping("manage_product_edit")
	public String editproduct(@ModelAttribute("id") String id, Model model, HttpSession session) {
		product = productDAO.get(id);
		model.addAttribute("product", product);

		model.addAttribute("UserClickedPRODUCTEDIT", "true");
		return "admin";
	}

	@RequestMapping("/editproduct")
	public String Editproduct(Model model, HttpSession session, @ModelAttribute("id") String id,@RequestParam("image") MultipartFile file,
			@ModelAttribute("name") String name, @ModelAttribute("price") int price, @ModelAttribute("stock") String stock,
			@ModelAttribute("category_id") String category_id, @ModelAttribute("supplier_id") String supplier_id) {
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		product.setCategory_id(category_id);
		product.setSupplier_id(supplier_id);
		if (productDAO.update(product)) 
		{
			 Util.upload(path, file, product.getId()+".jpg");
			model.addAttribute("message", "Product Edited");
			session.setAttribute("product", product);
			List<Product> productList = productDAO.list();
			session.setAttribute("ProductList", productList);
		} else {
			model.addAttribute("message", "Error Occurred");
		}

		model.addAttribute("EditProduct", "true");
		return "admin";
	}

	@RequestMapping("/displayProduct")
	public String displayProduct(Model model, HttpSession session,
			@ModelAttribute("categoryId") String categoryId, @ModelAttribute("subCategoryId") String subCategoryId) {

		List<Product> productList = productDAO.listByCategoryAndSubCategory(categoryId, subCategoryId);
		if (productList != null) {
			model.addAttribute("productCountMsg", productList.size() + " product(s) found !!!");
			session.setAttribute("productListBySubCategory", productList);
			model.addAttribute("ShowProductsForSubCategory", true);
		} else {
			model.addAttribute("productCountMsg", "No products found for this category !!!");
		}

		return "index";
	}

	 @RequestMapping("show_product/get/{id}")
	    public ModelAndView getSelectedProduct(@PathVariable("id") String id, RedirectAttributes redirectAttributes,HttpSession session )
	    {
	    
	    	ModelAndView mv = new ModelAndView("redirect:/index");			
	    	redirectAttributes.addFlashAttribute("selectedProduct", productDAO.get(id));
	    	String loggedInUserid = (String) session.getAttribute("loggedInUserID");
	  
	        return mv;
	     }
	 
	 @RequestMapping("/searchProduct")
		public ModelAndView searchProduct(@RequestParam("search") String searchname, HttpServletRequest request)
			{
	
				ModelAndView model=new ModelAndView("index");
				List<Product> list = productDAO.getAll();
				List<Product> productList=new ArrayList<Product>();
				for(int i=0;i<list.size(); i++)
					if(list.get(i).getName().toLowerCase().contains(searchname.toLowerCase()))
						productList.add((Product) list.get(i));
				model.addObject("productList",productList);
				model.addObject("searchname",searchname);
				model.addObject("Param", "SearchResult");
				return model;
			}

}