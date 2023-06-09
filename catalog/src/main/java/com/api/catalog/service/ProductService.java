package com.api.catalog.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.catalog.model.ProductModel;
import com.api.catalog.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public ProductModel save(ProductModel productModel) {
		return productRepository.save(productModel);
	}
	
	
	
	
}
