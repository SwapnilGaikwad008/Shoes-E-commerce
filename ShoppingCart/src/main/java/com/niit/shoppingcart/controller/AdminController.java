package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SubCategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.SubCategory;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.util.Util;

@Controller
public class AdminController {
	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private Product product;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SubCategoryDAO subCategoryDAO;

	@Autowired
	private SubCategory subcategory;

	
	@Autowired
	private ProductDAO productDAO;
	private String path = "D:\\workspace\\ShoppingCart\\src\\main\\webapp\\resources\\img";

	 @RequestMapping("/addcategory")
	 public String Addcategory(Model model, HttpSession session, @ModelAttribute("id") String id, @ModelAttribute("name") String name, @ModelAttribute("description") String description)
	 {
		 category.setId(id);
		 category.setName(name);
		 category.setDescription(description);
 if(categoryDAO.save(category))
	 
 {
	 model.addAttribute("message","Category added");
	 
	 session.setAttribute("category", category);
	   List<Category> categoryList = categoryDAO.list();
	   session.setAttribute("CategoryList", categoryList);
 }
 else
	 model.addAttribute("message","Error occured");
  model.addAttribute("UserClickedCATEGORY", "true");
  
  return "admin";
		} 
	 
	 
	 @RequestMapping("/addsupplier")
	 public String Addsupplier(Model model, HttpSession session, @ModelAttribute("id") String id, @ModelAttribute("name") String name, @ModelAttribute("address") String address )
	 {
		 supplier.setId(id);
		 supplier.setName(name);
		 supplier.setAddress(address);
      if(supplierDAO.save(supplier))
      {
    	  model.addAttribute("message", "Supplier added");
    	  
    	  session.setAttribute("supplier", supplier);
    	  List<Supplier> supplierList = supplierDAO.list();
    	  session.setAttribute("SupplierList", supplierList);
      }
      else
      {
    	  model.addAttribute("message", "Error Occured"); 
      }
      model.addAttribute("UserClickedSUPPLIER", "true");
          return "admin";
	 }
	  
	 
	 @RequestMapping("/addsubcategory")
		public String Addsubcategory(Model model, HttpSession session, @ModelAttribute("id") String id,
				@ModelAttribute("name") String name, @ModelAttribute("description") String description) {
			subcategory.setId(id);
			subcategory.setName(name);
			subcategory.setDescription(description);
			if (subCategoryDAO.save(subcategory))
			{
				model.addAttribute("message", "SubCategory added");
				session.setAttribute("subcategory", subcategory);
				List<SubCategory> subcategoryList = subCategoryDAO.list();
				session.setAttribute("SubCategoryList", subcategoryList);
			} else
				model.addAttribute("message", "Error occured");
			model.addAttribute("UserClickedSUBCATEGORY", "true");

			return "admin";
		}

	 
	 @RequestMapping("/addproduct")
	 public String Addproduct(Model model, HttpSession session, @RequestParam("image") MultipartFile file, @ModelAttribute("subcategory_id") String subcategory_id,  @ModelAttribute("id") String id, @ModelAttribute("name") String name, @ModelAttribute("price") int price,@ModelAttribute("stock") String stock, @ModelAttribute("category_id") String category_id, @ModelAttribute("supplier_id") String supplier_id, @ModelAttribute("description") String description)
	 {
		 product.setId(id);
		 product.setName(name);
		 product.setPrice(price);
		 product.setStock(stock);
		 product.setDescription(description);
		 product.setCategory_id(category_id);
       	product.setSubcategory_id(subcategory_id);
		 product.setSupplier_id(supplier_id);
	
		 if(productDAO.save(product))
		 {
		 Util.upload(path, file, product.getId()+".jpg");
			 model.addAttribute("message", "Product added");
			 session.setAttribute("product", product);
			 List<Product> productList = productDAO.list();
			 session.setAttribute("ProductList", productList);
		 }else
		 {
			 model.addAttribute("message", "Error occured");
			 model.addAttribute("UserClickedPRODUCT", "true");
		 }
		 
		 return "admin";
	 }
	/*@RequestMapping("Category")
	public ModelAndView categories() {
		log.debug("Starting of the method categories");
		ModelAndView mv = new ModelAndView("Category");
		mv.addObject("category", category);
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("categoryList", categoryDAO.list());
		log.debug("Ending of the method categories");
		return mv;
	}
*/
  /*	 @RequestMapping("manageProducts")
	public ModelAndView products() {
		log.debug("Starting of the method products");
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("product", product);
		mv.addObject("productList", productDAO.list());
		mv.addObject("category", category);
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("supplier", supplier);
		mv.addObject("supplierList", supplierDAO.list());
		log.debug("Ending of the method products");
		return mv;
	}*/

/*	@RequestMapping("manageSuppliers")
	public ModelAndView suppliers() {
		log.debug("Starting of the method suppliers");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("supplier", supplier);
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("supplierList", supplierDAO.list());
		log.debug("Ending of the method suppliers");
		return mv;
	}   */
	
	 
	 @RequestMapping(value = {"/categorytable"})
		public String categorytable(Model model, HttpSession session)
		
		{
		 model.addAttribute("UserClickedViewCategoryTable", "true");
		   List<Category> categoryList = categoryDAO.list();
		   session.setAttribute("CategoryList", categoryList);
		 
		 			return "admin";
		}
	 
	 @RequestMapping("/category")
		public String Category(Model model)

		{
			model.addAttribute("UserClickedCATEGORY", "true");
			return "admin";
		}
	 
       
	 @RequestMapping(value = {"/suppliertable"})
	 public String suppliertable(Model model, HttpSession session)
	 {
		 model.addAttribute("UserClickedViewSupplierTable", "true");
		  List<Supplier> supplierList = supplierDAO.list();
    	  session.setAttribute("SupplierList", supplierList);
    	  
		 return "admin";
	 }
	 
	 @RequestMapping("/supplier")
	 public String Supplier(Model model)
	 {
		 model.addAttribute("UserClickedSUPPLIER", "true");
		 return "admin";
	 }
	 
	 @RequestMapping(value = {"/producttable"})
	 public String producttable(Model model, HttpSession session)
	 {
		 model.addAttribute("UserClickedViewProductTable", "true");
		  List<Product> productList = productDAO.list();
    	  session.setAttribute("ProductList", productList);
    	  
		 return "admin";
	 }
	 
	 @RequestMapping("/product")
	 public String Product(Model model)
	 {
		 model.addAttribute("UserClickedProduct", "true");
		 return "admin";
	 }
	 
	 @RequestMapping("/subcategorytable")
		public String subcategorytable(Model model, HttpSession session)

		{
			model.addAttribute("UserClickedViewSubCategoryTable", "true");
			List<SubCategory> categoryList = subCategoryDAO.list();
			session.setAttribute("SubCategoryList", categoryList);

			return "admin";
		}


		@RequestMapping("/subcategory")
		public String SubCategory(Model model)

		{
			model.addAttribute("UserClickedSUBCATEGORY", "true");
			return "admin";
		}

	 
}