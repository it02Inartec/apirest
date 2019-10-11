package com.jenbeuses.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jenbeuses.apirest.entity.Product;
import com.jenbeuses.apirest.service.ProductService;

@RestController
@RequestMapping("/api")

public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	/* http://localhost:8080/api/products */
	@GetMapping("/products")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	/* http://localhost:8080/api/products/1 */
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId){
		Product product = productService.findById(productId);
		
		if(product==null) {
			throw new RuntimeException("Product id not found -"+productId);
		}
		
		return product;
	}
	
	/* http://localhost:8080/api/products */
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product){
		product.setId(0);
		productService.save(product);
		
		return product;
	}
	
	/* http://localhost:8080/api/products */
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product){
		productService.save(product);
		
		return product;
	}
	
	/* http://localhost:8080/api/products/1 */
	@DeleteMapping("/products/{productId}")
	public String deleteProduct(@PathVariable int productId){
		Product product = productService.findById(productId);
		
		if(product==null) {
			throw new RuntimeException("Product id not found -"+productId);
		}
		
		productService.deleteById(productId);
		
		return "Deleted product id - "+productId;
	}
}
