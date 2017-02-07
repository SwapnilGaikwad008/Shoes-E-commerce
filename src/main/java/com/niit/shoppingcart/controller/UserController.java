package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.SubCategory;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController {

	public static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO UserDAO;

	@Autowired
	User User;

	//@Autowired
	//private CartDAO cartDAO;

	//@Autowired
	//private MyCart myCart;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private SubCategoryDAO subcategoryDAO;

	@Autowired
	private SubCategory subcategory;
	

	@Autowired
	private Supplier supplier;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartDAO cartDAO;

	
	@Autowired
	private HttpSession session;

	@Autowired
	@Qualifier("myAuthenticationManager")
	private AuthenticationManager authenticationManager;

	/**
	 * if invalid credentials -> Home page , login , error message if valid
	 * credentials && he is admin -> AdminHome page ,logout link if valid
	 * credentials && he is end User -> Home page, myCart, logout link
	 * 
	 * @param UserID
	 * @param password
	 * @return it will return data and page name where to return
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public ModelAndView validate(HttpServletRequest request,@RequestParam(value = "emailId") String emailId,
			@RequestParam(value = "password") String password) {
		log.debug("Starting of the method validate");

		// ModelAndView mv = new ModelAndView("/index");
		ModelAndView mv = new ModelAndView("/index");
		ModelAndView mu = new ModelAndView("/admin");
		
		User = UserDAO.isValidUser(emailId, password);
		// if the record exist with this UserID and password it will return User
		// details else will return null

		if (User != null) {
		log.debug("Valid Credentials");
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(emailId, password);

		// Authenticate the user
	    Authentication authentication = authenticationManager.authenticate(authRequest);
	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    securityContext.setAuthentication(authentication);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
	
		
			session.setAttribute("loggedInUser", User.getName());
			session.setAttribute("loggedInUserID", User.getId());

			session.setAttribute("User", User); //
			session.setAttribute("supplier", supplier);
			session.setAttribute("supplierList", supplierDAO.list());

			session.setAttribute("category", category);
			session.setAttribute("categoryList", categoryDAO.list());
			
			session.setAttribute("subcategory", subcategory);
			session.setAttribute("subcategoryList", subcategoryDAO.list());
			
			session.setAttribute("productList", productDAO.list());
			List<Cart> cartList = cartDAO.getActiveByUser(User.getId());
			session.setAttribute("cartItemCount", cartList.size());
			
			
			session.setAttribute("loggedOut", false);
			mv.addObject("ShowMainPage", true);

			if("ROLE_ADMIN".equalsIgnoreCase(User.getRole())) {
				session.setAttribute("isAdmin", true);
				return mu;
			} else {
				session.setAttribute("isAdmin", false);
			}
		} else {
			log.debug("Invalid Credentials");

			mv.addObject("invalidCredentials", "true");
			mv.addObject("message", "Invalid Credentials");
			mv.addObject("ShowMessage", true);

		}
		log.debug("Ending of the method validate");
		return mv;
	}
	
	

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		log.debug("Starting of the method logout");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		ModelAndView mv = new ModelAndView("/index");

		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate(); // will remove the attributes which are added to session

		session = request.getSession(true);

		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("subcategoryList", subcategoryDAO.list());
		session.setAttribute("productList", productDAO.list());

		mv.addObject("message", "You have successfully logged out");
		mv.addObject("ShowMessage", true);
		session.setAttribute("loggedOut", true);

		log.debug("Ending of the method logout");
		return mv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUser(@ModelAttribute User User) {
		log.debug("Starting of the method registerUser");
		ModelAndView mv = new ModelAndView("index");
		if (UserDAO.get(User.getId()) == null) {
			User.setRole("ROLE_USER"); // all the Users are end Users by default
			UserDAO. save(User);
			log.debug("You are successfully register");
			mv.addObject("successMsg", "You are successfully registered " + User.getName() + " try logging in now !!!");
		} else {
			log.debug("User exist with this id");
			mv.addObject("errorMessage", "User exist with this id");
		}
		log.debug("Ending of the method registerUser");
		return mv;
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public ModelAndView loginError(Model model) {
		log.debug("Starting of the method loginError");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("ShowMessage", true);
		mv.addObject("message", "Invalid credentials");
		log.debug("Ending of the method loginError");
		return mv;

	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("ShowMessage", true);
		mv.addObject("message", "You are not authorized to access this page");
		log.debug("Ending of the method accessDenied");
		return mv;

	}

}
