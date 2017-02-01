package com.niit.shoppingcart.daoimpl;


import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SubCategoryDAO;
import com.niit.shoppingcart.model.SubCategory;


@Repository("subCategoryDAO")
public class SubCategoryDAOImpl implements SubCategoryDAO,Serializable {
	

	
	@Autowired
	private SessionFactory sessionFactory;

	public SubCategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<SubCategory> list() {

		String hql = "from SubCategory";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public boolean save(SubCategory subcategory) {

		try {
			if (get(subcategory.getId()) != null) {
				return false;
			}

			subcategory = (SubCategory) sessionFactory.getCurrentSession().merge(subcategory);
			sessionFactory.getCurrentSession().save(subcategory);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean update(SubCategory subcategory) {
		try {
			if (get(subcategory.getId()) == null) {
				return false;
			}
			subcategory = (SubCategory) sessionFactory.getCurrentSession().merge(subcategory);
			sessionFactory.getCurrentSession().update(subcategory);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}
	}

	@Transactional
	public boolean delete(SubCategory subcategory) {
		try {
			if (get(subcategory.getId()) != null) {
				subcategory = (SubCategory) sessionFactory.getCurrentSession().merge(subcategory);
				sessionFactory.getCurrentSession().delete(subcategory);
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
	  public SubCategory get(String id) {
		return (SubCategory) sessionFactory.getCurrentSession() .get(SubCategory.class,id);
		}

}