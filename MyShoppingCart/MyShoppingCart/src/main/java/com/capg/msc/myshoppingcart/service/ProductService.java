package com.capg.msc.myshoppingcart.service;

import java.util.List;

import com.capg.msc.myshoppingcart.beanss.Product;

public interface ProductService {

	
	public List<Product> getAllProducts();
	
	public Product saveProduct(Product p);
	public boolean deleteProduct(Product p, int pId);
	public Product updateProduct(Product p,int id);
}