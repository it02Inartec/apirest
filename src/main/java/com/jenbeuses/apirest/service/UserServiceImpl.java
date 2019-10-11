package com.jenbeuses.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenbeuses.apirest.dao.UserDAO;
import com.jenbeuses.apirest.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> findAll() {
		List<User> listUsers = userDAO.findAll();
		return listUsers;
	}
	
	@Override
	public User findById(int id) {
		User user = userDAO.findById(id);
		return user;
	}

	@Override
	public User findUser(User user) {
		User userResult = userDAO.findUser(user);
		return userResult;
	}

	@Override
	public void save(User user) {
		userDAO.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jenbeuses.apirest.service.UserService#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		userDAO.deleteById(id);
	}

}
