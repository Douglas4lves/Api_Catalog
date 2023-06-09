package com.api.catalog.service;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.catalog.model.ProductModel;
import com.api.catalog.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public ProductModel save(ProductModel productModel) {
		return productRepository.save(productModel);
	}
	
	public List<ProductModel> findAll(){
		return productRepository.findAll();
	}
	
	public Optional<ProductModel> findById(Integer id){
		return productRepository.findById(id);
	}
	
	@Transactional
	public void delete(ProductModel productModel) {
		productRepository.delete(productModel);
	}
	
}
