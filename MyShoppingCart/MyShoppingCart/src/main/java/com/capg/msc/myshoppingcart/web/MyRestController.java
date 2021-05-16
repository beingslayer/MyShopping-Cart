package com.capg.msc.myshoppingcart.web;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.msc.myshoppingcart.beanss.Product;
import com.capg.msc.myshoppingcart.service.ProductService;

@RestController
@RequestMapping("/api")
public class MyRestController {
	
	@Autowired
	private ProductService service;
		
	@GetMapping("/home")
	public String homeRequest()
	{
		return " Welcome User! : My Shopping App1 " + LocalDateTime.now();
		
	}

	
	public MyRestController() {
		System.out.println("---> Inside the ProductRestController Constructor");
		
	}
	
	@PostMapping("/product")
	public Product insertProduct(@RequestBody Product product) {
		
		service.saveProduct(product);
		return product;
		
	}
	
	
	@GetMapping("/products")
	public List<Product> insertAllProduct(@RequestBody Product product) {
		
		
		return service.getAllProducts();
		
	}
	@GetMapping("/product")
	public List<Product> getProduct()
	{
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
	
}