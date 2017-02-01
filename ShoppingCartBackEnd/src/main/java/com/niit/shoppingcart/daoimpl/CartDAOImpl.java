package com.niit.shoppingcart.daoimpl;



import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

@Repository("CartDAO")
public class CartDAOImpl implements CartDAO, Serializable{

	@Autowired
	SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Cart cart) {
		try {
			if (get(cart.getId()) == null) {
				return false;
			}
			cart = (Cart) sessionFactory.getCurrentSession().merge(cart);
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(int id) {
		Cart cartDelete = new Cart();
		cartDelete.setId(id);
		try {
			sessionFactory.getCurrentSession().delete(cartDelete);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Cart get(int id) {
		String hql = "from Cart where cartid= " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		List<Cart> listCart = (List<Cart>) query.list();
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		return null;
	}

	@Transactional
	public Long getTotalAmount(String userId) {
		String hql = "select sum(price) from Cart where user_id= " + "'" + userId + "' and ordered = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long) query.uniqueResult();
		return sum;
	}

	@Transactional
	public List<Cart> getActiveByUser(String userId) {
		String hql = "from Cart where user_id= " + "'" + userId + "' and ordered = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
