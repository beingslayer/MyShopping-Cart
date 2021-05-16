package com.capg.mse.MyShoppingApp.dao;

import java.util.List;

import com.capg.mse.MyShoppingApp.bean.Product;

public interface CustomProductRepository {
	
	public List<Product> getProductByCategory(String productCategory);
	public List<Product> getProductByCategoryAndPrice(String productCategory, int range1, int range2);

}
