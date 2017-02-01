package com.niit.shoppingcart.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;
@Repository("supplierDAO")

public class SupplierDAOImpl implements SupplierDAO,Serializable {
   


	@Autowired
	SessionFactory sessionFactory;


	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Supplier> list() {

		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
	
	@Transactional
	public boolean save(Supplier supplier) {

		try {
			if (get(supplier.getId())!= null){
				return false;
			}
			supplier = (Supplier)sessionFactory.getCurrentSession().merge(supplier);
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean update(Supplier supplier) {
		try {
			if(get(supplier.getId())== null)
			{
				return false;
			}
			supplier = (Supplier) sessionFactory.getCurrentSession().merge(supplier);
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}

	}
   @Transactional
	public boolean delete(Supplier supplier) {
		try{
			if(get(supplier.getId())!= null){
				supplier = (Supplier)sessionFactory.getCurrentSession().merge(supplier);
				sessionFactory.getCurrentSession().delete(supplier);
				return true;
		}else{
		return false;
		}
	}catch(HibernateException e){
		e.printStackTrace();
		return false ;
	}
			
   }
		@Transactional
		public Supplier get(String id) {
			return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class,id);
		}



		
	}

	


