package com.jenbeuses.apirest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jenbeuses.apirest.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<User> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		List< User> users = theQuery.getResultList();
		return users;
	}
	
	@Override
	public User findUser(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		List<User> users = new ArrayList<>();
		User userResult = null;
		users = currentSession.createCriteria(User.class)
			    .add( Restrictions.eq("username", user.getUsername() ) )
			    .add( Restrictions.eq("password", user.getPassword() ) )
			    .list();
		
		if(!users.isEmpty()) {
			userResult = users.get(0);
		}
		return userResult;
	}

	@Override
	public User findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		User user = currentSession.get(User.class, id);
		return user;
	}

	@Override
	public void save(User product) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(product);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession.createQuery("delete from Product where id=:idUser");
		
		theQuery.setParameter("idUser", id);
		theQuery.executeUpdate();
	}

}
