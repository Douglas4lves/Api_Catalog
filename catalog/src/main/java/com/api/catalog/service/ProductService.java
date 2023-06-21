package com.api.catalog.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.catalog.model.ProductModel;
import com.api.catalog.repository.ProductRepository;
import com.api.catalog.service.exceptions.CodAlreadyExistsException;
import com.api.catalog.service.exceptions.EntityNotFoundException;

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
	
	public ProductModel findById(Integer id){
		return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID não encontrado: " + id));
	}
	
	public boolean existsByCodProduct(int codProduct) {
		boolean product = productRepository.existsByCodProduct(codProduct);
		if(product != false) {
			throw new CodAlreadyExistsException("Código do produto não pode ser igual a código já existente: " + codProduct);
		}else {
			return true;
		}
		
	}
	
	public ProductModel getProductByCod(int codProduct) {
		ProductModel product = productRepository.getByCodProduct(codProduct);
		if(product == null ) {
			throw new EntityNotFoundException("Código do produto não encontrado: " + codProduct);
		}
		return product;
	}
	
	@Transactional
	public void delete(ProductModel productModel) {
		productRepository.delete(productModel);
	}
	
}
