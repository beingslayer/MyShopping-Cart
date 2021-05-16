package com.capg.mse.MyShoppingApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mse.MyShoppingApp.bean.Product;
import com.capg.mse.MyShoppingApp.dao.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	ProductRepository repo;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	@Transactional
	public Product saveProduct(Product p) {
		// TODO Auto-generated method stub
		
		repo.save(p);
		return p;
	}
	
	@Override
	public Product updateProduct(Product p, int id) {
		Optional<Product> up = repo.findById(id);
		if(up.isPresent())
		{
			Product product = up.get();
			product.setProductName(p.getProductName());
			product.setProductCost(p.getProductCost());
			product.setRating(p.getRating());
			product.setCategory(p.getCategory());
			return repo.save(product);
		}
		return null;
	}
	

	@Override
    @Transactional
	public boolean deleteProduct(Product p, int pId) {
		boolean isDeleted = false;
		Product p1 = null;
		List<Product> pList = getAllProducts();
		for(Product product : pList) {
			if(product.getProductId() == pId) {
				isDeleted = true;
				p1 = product;
			}
		}
	
		repo.delete(p);
		return isDeleted;
		
	}
	
	@Override
	public List<Product> getAllProductsByCategory(String category) {
		
		return repo.getProductByCategory(category);
	}

	
	@Override
	public List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2) 
	{
		
		return repo.getProductByCategoryAndPrice(category, range1, range2);
	}


	@Override
	public Product getProductById(int id)  {
		return repo.findById(id).get();
		
	}


	
	
	
	


}
