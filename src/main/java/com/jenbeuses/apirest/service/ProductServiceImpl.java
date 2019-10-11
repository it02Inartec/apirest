package com.jenbeuses.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenbeuses.apirest.dao.ProductDAO;
import com.jenbeuses.apirest.entity.Product;

/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {

	/** The product DAO. */
	@Autowired
	private ProductDAO productDAO;

	/* (non-Javadoc)
	 * @see com.jenbeuses.apirest.service.ProductService#findAll()
	 */
	@Override
	public List<Product> findAll() {
		List<Product> listProducts = productDAO.findAll();
		return listProducts;
	}

	/* (non-Javadoc)
	 * @see com.jenbeuses.apirest.service.ProductService#findById(int)
	 */
	@Override
	public Product findById(int id) {
		Product product = productDAO.findById(id);
		return product;
	}

	/* (non-Javadoc)
	 * @see com.jenbeuses.apirest.service.ProductService#save(com.jenbeuses.apirest.entity.Product)
	 */
	@Override
	public void save(Product product) {
		productDAO.save(product);
	}

	/* (non-Javadoc)
	 * @see com.jenbeuses.apirest.service.ProductService#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		productDAO.deleteById(id);
	}

}
