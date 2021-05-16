package com.capg.msc.myshoppingcart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.msc.myshoppingcart.beanss.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	


}
