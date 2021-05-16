package com.capg.mse.MyShoppingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capg.mse.MyShoppingApp.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>, CustomProductRepository{

	
}
