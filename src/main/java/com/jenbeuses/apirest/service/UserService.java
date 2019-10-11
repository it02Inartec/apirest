package com.jenbeuses.apirest.service;

import java.util.List;

import com.jenbeuses.apirest.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findUser(User user);
	
	public User findById(int id);
	
	public void save(User user);
	
	public void deleteById(int id);
	
}
