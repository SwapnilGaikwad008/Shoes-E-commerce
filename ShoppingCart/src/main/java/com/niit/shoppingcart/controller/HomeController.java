package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SubCategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class HomeController {

	Logger log = LoggerFactory.getLogger(HomeController.class);


	@Autowired
	User user;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private SubCategoryDAO subcategoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private CartDAO cartDAO;

	
	/**
	 * Category list will load and set to session
	 * 
	 * @param session
	 * @return
	 */
    //http://localhost:8080/ShoppingCartFrontEnd/
	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session) {
		log.debug("Starting of the method onLoad");
		ModelAndView mv = new ModelAndView("/index");
		
		if(session.getAttribute("loggedInUserID") == null) {
			session.setAttribute("loggedOut", true);
			session.setAttribute("supplierList", supplierDAO.list());
			session.setAttribute("categoryList", categoryDAO.list());
			session.setAttribute("subcategoryList", subcategoryDAO.list());
			session.setAttribute("productList", productDAO.list());
		}
		
		mv.addObject("ShowMainPage", true);
		log.debug("Ending of the method onLoad");
		return mv;
	}
	
	@RequestMapping("/index")
	public ModelAndView home(HttpSession session) {
		log.debug("Starting of the method onLoad");
		ModelAndView mv = new ModelAndView("/index");
		
		if(session.getAttribute("loggedInUserID") == null) {
			session.setAttribute("loggedOut", true);
			session.setAttribute("categoryList", categoryDAO.list());
			session.setAttribute("subcategoryList", subcategoryDAO.list());
			session.setAttribute("productList", productDAO.list());
		}
		
		mv.addObject("ShowMainPage", true);
		log.debug("Ending of the method onLoad");
		return mv;
	}


	@RequestMapping("/registration")
	public ModelAndView registerHere() {
		log.debug("Starting of the method registration");
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("ShowRegistrationPage", true);
		log.debug("Ending of the method registration");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView loginHere(HttpSession session) {
		log.debug("Starting of the method loginHere");
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("ShowLoginPage", true);
		log.debug("Ending of the method loginHere");
		return mv;
	}

	/*
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value = "searchKey") String searchKey) {
		ModelAndView mv = new ModelAndView("/index");
		return mv;
		
	}*/
	
	

}