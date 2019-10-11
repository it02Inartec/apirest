package com.jenbeuses.apirest.service;

import java.util.List;
import com.jenbeuses.apirest.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Product findById(int id);
	
	public void save(Product product);
	
	public void deleteById(int id);
}
