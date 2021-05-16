package com.capg.mse.MyShoppingApp.service;

import java.util.List;

import com.capg.mse.MyShoppingApp.bean.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	public Product saveProduct(Product p);
	public boolean deleteProduct(Product p, int pId);
	public Product updateProduct(Product p,int id);
	public List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2);
	public Product getProductById(int id);
	public List<Product> getAllProductsByCategory(String category);
	

}
