package com.niit.shoppingcart.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.model.Orders;

@Repository("orderDAO")
public class OrdersDAOImpl implements OrdersDAO, Serializable {

	
	@Autowired
	  SessionFactory sessionFactory;
		
	   public OrdersDAOImpl(SessionFactory sessionFactory)
	   {
		   this.sessionFactory=sessionFactory;
	   }
	   
	   
	   @Transactional
	   public boolean saveOrUpdate(Orders orders) {
	   	try{
	   			sessionFactory.getCurrentSession().saveOrUpdate(orders);
	   		return true;
	   	}
	   	catch(HibernateException e){
	   		e.printStackTrace();
	   	return false;
	   	}
	   }

	   @Transactional
	   public boolean update(Orders orders) {
	   	try{
	  		sessionFactory.getCurrentSession().update(orders);
	   		return true;
	   	}
	   	catch(HibernateException e){
	         e.printStackTrace();		
	   	return false;
	   	}
	   }

	   @Transactional
	   public boolean delete(Orders orders) {
	   	   
	   	try{
	   			sessionFactory.getCurrentSession().delete(orders);
	   			return true;
	   		}	
	   	catch(HibernateException e){
	   		e.printStackTrace();
	   	return false;
	   	}
	   }


	   @Transactional  
	   public Orders get(String id) {
	   	return (Orders) sessionFactory.getCurrentSession().get(Orders.class,id);
	   }

	   
	   @Transactional
	  public List<Orders> list() {
	  	String hql="from Orders";
	  	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	  	return  query.list();
	  }
}
