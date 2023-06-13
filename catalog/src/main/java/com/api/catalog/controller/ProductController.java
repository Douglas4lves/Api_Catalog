package com.api.catalog.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	public ResponseEntity<Object> getProductById(@PathVariable(value = "id") Integer id){
		Optional<ProductModel> productModelOptional = productService.findById(id);
		if(!productModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(productModelOptional.get());
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
	public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") Integer id, @RequestBody @Valid ProductDto productDto){
		
		Optional<ProductModel> productModelOptional = productService.findById(id);
		CategoryModel optionalCategory = categoryService.findById(productDto.getCategory());
		var category = new CategoryModel();
		category.setId(optionalCategory.getId());
		category.setName(optionalCategory.getName());
		
		var productModel = new ProductModel();
		BeanUtils.copyProperties(productDto, productModel);
		productModel.setId(productModelOptional.get().getId());
		productModel.setName(productDto.getName());
		productModel.setCod_product(productDto.getCod_product());
		productModel.setImageurl(productDto.getImageurl());
		productModel.setCategory(category);
		
		return ResponseEntity.status(HttpStatus.OK).body(productService.save(productModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Integer id){
		Optional<ProductModel> productOptional = productService.findById(id);
		if(!productOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
		};
		
		productService.delete(productOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso");
	}
	
}
