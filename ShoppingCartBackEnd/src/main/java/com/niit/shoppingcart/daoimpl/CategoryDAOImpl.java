package com.niit.shoppingcart.daoimpl;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO,Serializable {
	

	
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Category> list() {

		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public boolean save(Category category) {

		try {
			if (get(category.getId()) != null) {
				return false;
			}

			category = (Category) sessionFactory.getCurrentSession().merge(category);
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean update(Category category) {
		try {
			if (get(category.getId()) == null) {
				return false;
			}
			category = (Category) sessionFactory.getCurrentSession().merge(category);
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}
	}

	@Transactional
	public boolean delete(Category category) {
		try {
			if (get(category.getId()) != null) {
				category = (Category) sessionFactory.getCurrentSession().merge(category);
				sessionFactory.getCurrentSession().delete(category);
				return true;
			} else {
				return false;
			}
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	  public Category get(String id) {
		return (Category) sessionFactory.getCurrentSession() .get(Category.class,id);
		}

}
