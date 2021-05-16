package com.capg.msc.myshoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.msc.myshoppingcart.beanss.Product;
import com.capg.msc.myshoppingcart.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO repo;

	@Override
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}
	
	
	
	@Override
	@Transactional
	public Product saveProduct(Product p) {
		
		repo.save(p);
		return null;
		
		
	}
	@Override
	public Product updateProduct(Product p, int id) {
		Optional<Product> up = repo.findById(id);
		if(up.isPresent())
		{
			Product product = up.get();
			product.setProductName(p.getProductName());
			product.setProductCost(p.getProductCost());
			product.setStarRating(p.getStarRating());
			product.setAvailable(p.getAvailable());
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

	
	
	

}
