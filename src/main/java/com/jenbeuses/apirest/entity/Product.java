package com.jenbeuses.apirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Product.
 */
@Entity
@Table(name = "product")
public class Product {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/** The name. */
	@Column(name = "name")
	private String name;

	/** The brand. */
	@Column(name = "brand")
	private String brand;

	/** The madein. */
	@Column(name = "madein")
	private String madein;

	/** The price. */
	@Column(name = "price")
	private double price;

	/**
	 * Instantiates a new product.
	 */
	public Product() {
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 * @param brand
	 *            the brand
	 * @param madein
	 *            the madein
	 * @param price
	 *            the price
	 */
	public Product(int id, String name, String brand, String madein, double price) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 *
	 * @param brand
	 *            the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the madein.
	 *
	 * @return the madein
	 */
	public String getMadein() {
		return madein;
	}

	/**
	 * Sets the madein.
	 *
	 * @param madein
	 *            the new madein
	 */
	public void setMadein(String madein) {
		this.madein = madein;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price
	 *            the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", madein=" + madein + ", price=" + price
				+ "]";
	}

}
