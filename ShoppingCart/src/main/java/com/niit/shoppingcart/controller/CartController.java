package com.niit.shoppingcart.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;


@Controller
public class CartController {
	

	Logger log = LoggerFactory.getLogger(CartController.class);
	

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= "/cartTable", method = RequestMethod.GET)
	public String cart(Model model, HttpSession session)
	{
		log.debug("Starting of the method cart");

		String loggedInUserid = (String) session.getAttribute("loggedInUserID");

		List<Cart> cartList = cartDAO.getActiveByUser(loggedInUserid);

		if (cartList == null || cartList.isEmpty()) {
			model.addAttribute("message", "Cart is empty !!!");
			model.addAttribute("ShowMessage", true);
		} else {
			model.addAttribute("cartList", cartList);
			model.addAttribute("totalAmount", cartDAO.getTotalAmount(loggedInUserid));
			model.addAttribute("ShowCartTable", true);
		}

		return "index";
	}
	
	@RequestMapping(value="/addToCart",method = RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam("productId") String productId , HttpSession session)
	{

		// get the product based on product name
		Product product = productDAO.get(productId);

		cart.setProductName(product.getName());
		cart.setStock(1);
		cart.setPrice(product.getPrice());
		String loggedInUserId = (String) session.getAttribute("loggedInUserID");
		cart.setUser_id(loggedInUserId);
		cart.setId(ThreadLocalRandom.current().nextInt(100, 1000000 + 1));
		cart.setOrdered(0);
		cartDAO.save(cart);

		int cartItemCount = (Integer) session.getAttribute("cartItemCount") + 1;
		session.setAttribute("cartItemCount", cartItemCount);
		
		
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("message", "Successfully added the product to Cart !!!");
		mv.addObject("ShowMessage", true);

		return mv;
	}
	
	@RequestMapping("/manage_cart_remove")
	public String removeCart(@RequestParam("id") int cartId, Model model, HttpSession session) throws Exception
	{
		boolean flag = cartDAO.delete(cartId);
		if (flag) {
			model.addAttribute("message", "Successfully removed the item from your cart !!!");
			int cartItemCount = (Integer) session.getAttribute("cartItemCount") - 1;
			session.setAttribute("cartItemCount", cartItemCount);
		} else {
			model.addAttribute("message", "Error occurred !!!");
		}
        model.addAttribute("ShowMessage", true);
		return "index";
	}
}