package com.api.catalog.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.catalog.dto.ProductDto;
import com.api.catalog.model.CategoryModel;
import com.api.catalog.model.ProductModel;
import com.api.catalog.service.CategoryService;
import com.api.catalog.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@GetMapping
	public ResponseEntity<Object> listProducts(){
		List<ProductModel> list = productService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(list); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductModel> getProductById(@PathVariable(value = "id") Integer id){
		ProductModel productModelOptional = productService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(productModelOptional);
	}
	
	@PostMapping
	public ResponseEntity<Object> saveProduct(@RequestBody @Valid ProductDto productDto){
		
		CategoryModel optionalCategory = categoryService.findById(productDto.getCategory());
		var category = new CategoryModel();
		category.setId(optionalCategory.getId());
		category.setName(optionalCategory.getName());
		
		var productModel =new ProductModel();
		BeanUtils.copyProperties(productDto, productModel);
		productModel.setCategory(category);
		
		return ResponseEntity.status(HttpStatus.OK).body(productService.save(productModel));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductModel> updateProduct(@PathVariable(value = "id") Integer id, @RequestBody @Valid ProductDto productDto){
		
		ProductModel productModelOptional = productService.findById(id);
		CategoryModel optionalCategory = categoryService.findById(productDto.getCategory());
		var category = new CategoryModel();
		category.setId(optionalCategory.getId());
		category.setName(optionalCategory.getName());
		
		var productModel = new ProductModel();
		BeanUtils.copyProperties(productDto, productModel);
		productModel.setId(productModelOptional.getId());
		productModel.setCategory(category);
		return ResponseEntity.status(HttpStatus.OK).body(productService.save(productModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductModel> deleteProduct(@PathVariable(value = "id") Integer id){
		ProductModel productOptional = productService.findById(id);
		productService.delete(productOptional);
		return ResponseEntity.status(HttpStatus.OK).body(productOptional);
	}
	
	
}
