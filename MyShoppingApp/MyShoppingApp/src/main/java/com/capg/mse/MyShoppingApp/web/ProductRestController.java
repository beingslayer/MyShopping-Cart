package com.capg.mse.MyShoppingApp.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mse.MyShoppingApp.bean.Product;
import com.capg.mse.MyShoppingApp.exception.InvalidCategoryByUserException;
import com.capg.mse.MyShoppingApp.exception.InvalidCostRangeException;
import com.capg.mse.MyShoppingApp.service.ProductService;

@Validated
@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	private ProductService service;
	
	public ProductRestController() {
		System.out.println("Product Rest Controller Cunstructor");
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : My Shopping App "+LocalDateTime.now();
	}
	
	@PostMapping("/product")
	public Product insertProduct(@RequestBody @Valid Product product) {
		service.saveProduct(product);
		return product;
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@PutMapping("/product/{id}")
	public Product updateProduct(@RequestBody Product p,@PathVariable int id)
	{
		return service.updateProduct(p, id);
	}

	@PostMapping("/product/delete")
	public boolean deleteProduct(@RequestBody Product product) {
		return service.deleteProduct(product, product.getProductId());
	}
	
	@GetMapping("/product/{category}")
	public List<Product> getAllProductsByCategory(@PathVariable String category)
	{
		return service.getAllProductsByCategory(category);
	}
	
	@GetMapping("/products/{category}/{range1}/{range2}")
	public List<Product> getAllProductsByCategoryAndPrice(@PathVariable String category,
			@PathVariable int range1,@PathVariable int range2)throws InvalidCostRangeException
	{
		if(category.equals("Laptop")&&range1<10000)
		{
			throw new InvalidCostRangeException(range1,range2);
		}
		return service.getAllProductsByCategoryAndPrice(category, range1, range2);
	}
	
	@GetMapping("/products/category/{category}")
	public List<Product> getAllProductsByCategory1(@PathVariable String category)throws InvalidCategoryByUserException
	{
		
		Pattern pattern = Pattern.compile("[^0-9]+[A-Za-z]{6}+[^0-9]+");
		Matcher matcher = pattern.matcher(category);
		boolean matchFound = matcher.find();
		if(!matchFound)
		{
			throw new InvalidCategoryByUserException(category);
		}
		return service.getAllProductsByCategory(category);
	}
	
	
}
