package com.niit.shoppingcart.webflow;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Orders;
import com.niit.shoppingcart.model.PaymentMethod;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.ShippingAddress;
import com.niit.shoppingcart.model.User;

public class OrderWebflow  implements Serializable{
	
	public static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(OrderWebflow.class);
	
 
	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired 
	CartDAO cartDAO;
	
	@Autowired
	Cart cart;
	
	@Autowired
	Orders orders;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	Product product;
	
	@Autowired
	User user;
	
	public Orders initFlow(){
		log.debug("staring of initflow method");
		
		orders = new Orders();
		
		log.debug("Ending of initflow method");
		
		
		return orders;
		
	}
	
	public String addShippingAddress(Orders orders, ShippingAddress shippingAddress)
{
	log.debug("Staring of Add Shipping address");
	
	orders.setShippingAddress(shippingAddress);
	
	log.debug("Ending of add address");
			return "success";
}
	public String addBillingAddress(Orders Orders, BillingAddress billingAddress)
	{
		log.debug("Staring of Add Billing address");
		
		orders.setBillingAddress(billingAddress);
		
		log.debug("Ending of Add Billing address");
		
		return "success";
	}
	
	public String addPaymentMethod(Orders orders, PaymentMethod paymentMethod)
	{
log.debug("starting of the method addPaymentMethod");
		
		
		orders.setPaymentMethod(paymentMethod.getPaymentMethod());
		
		
		
		log.debug("Ending of the method addPaymentMethod");
		
		return "success";
	}
	
	public String confirmOrder(Orders orders)
	{
		log.debug("starting of the method confirmOrder");
		
		orders.setUser_id(user.getId());
		orders.setTotalAmount(product.getPrice());
		ordersDAO.saveOrUpdate(orders);
		
log.debug("Ending of the method confirmOrder");
		
		return "index";
	}
	
	
	
	
	
	
	
	
	
}
