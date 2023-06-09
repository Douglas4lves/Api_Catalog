package com.api.catalog.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String hello() {
		return ("hello");  
	}
	
	@PostMapping
	public ResponseEntity<Object> saveProduct(@RequestBody @Valid ProductDto productDto){
		
		Optional<CategoryModel> optionalCategory = categoryService.findById(productDto.getCategory());
		if(!optionalCategory.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não existe");
		};
		var category = new CategoryModel();
		category.setId(optionalCategory.get().getId());
		category.setName(optionalCategory.get().getName());
		
		var productModel =new ProductModel();
		BeanUtils.copyProperties(productDto, productModel);
		productModel.setCategory(category);
		 
	
		return ResponseEntity.status(HttpStatus.OK).body(productService.save(productModel));
		
	}
	
}
