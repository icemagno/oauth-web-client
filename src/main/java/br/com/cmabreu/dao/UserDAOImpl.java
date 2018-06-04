package br.com.cmabreu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cmabreu.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public UserDAOImpl() {
		//
	}
	
	public UserDAOImpl( SessionFactory sessionFactory ) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User loadByUsername(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where( builder.equal( root.get("name"), userName ) );
		Query q   = session.createQuery(query);
		User user = (User)q.getSingleResult();
		return user;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsersAdmin() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		List<User> admins = new ArrayList<User>();
		for (User u : usersList) {
			if ( u.isAdmin() ) admins.add( u );
		}
		return admins;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		return usersList;
	}

	@Override
	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist( user );		
	}

	@Override
	public User getUserById( Long userId ) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load( User.class, userId );
		return user;
	}

}
