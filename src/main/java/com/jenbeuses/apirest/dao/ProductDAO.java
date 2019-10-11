package com.jenbeuses.apirest.dao;

import java.util.List;

import com.jenbeuses.apirest.entity.Product;

public interface ProductDAO {
	
	public List<Product> findAll();
	
	public Product findById(int id);
	
	public void save(Product product);
	
	public void deleteById(int id);
}
