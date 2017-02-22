package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;


@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	// Logger log =
	// LoggerFactory.getLogger("com.niit.shopingcart.dao.UserDAOImpl");

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {

	}

	public UserDAOImpl(SessionFactory sessionFactory) {

		try {
			this.sessionFactory = sessionFactory;
			log.info(" The connection is established properly..");
		} catch (Exception e) {
			log.error("Not able to prepare connection.  Please check application" + "context java file");
			e.printStackTrace();
		}

	}

	@Transactional
	public List<User> list() {
		log.debug("Starting of the method list");
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("Ending of the method list");
		return list;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		log.debug("Starting of the method : saveOrUpdate ");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		log.debug("Ending of the method : saveOrUpdate ");
	}

	/*
	 * @Transactional public void saveOrUpdate(UserDetails userDetails) {
	 * sessionFactory.getCurrentSession().saveOrUpdate(userDetails); }
	 */

	@Transactional
	public void delete(String id) {
		log.debug("Starting of the method : delete ");
		try {
			User user = new User();
			user.setId(id);
			sessionFactory.getCurrentSession().delete(user);
			log.debug("Ending of the method : delete ");
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Transactional
	public User get(String id) {
		log.debug("Starting of the method : get ");
		String hql = "from User where id=" + "'" + id + "'";

		return getUserDetails(hql);

	}

	@Transactional
	public User getUserByName(String name) {
		log.debug("Starting of the method : getUserByName ");
		String hql = "from User where name=" + "'" + name + "'";

		return getUserDetails(hql);

	}

	@Transactional
	public User isValidUser(String emailId, String password)

	{
		log.debug("Starting of the method : isValidUser ");
		log.info("The user email id :" + emailId);

		String hql = "from User where mail = " + "'" + emailId + "'" + " and " + "password = " + "'" + password + "'";

		log.info(" The query is :" + hql);

		return getUserDetails(hql);

	}

	private User getUserDetails(String hql) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;

	}

}