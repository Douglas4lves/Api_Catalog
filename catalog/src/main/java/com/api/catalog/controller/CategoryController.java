package com.api.catalog.controller;

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

import com.api.catalog.dto.CategoryDto;
import com.api.catalog.model.CategoryModel;
import com.api.catalog.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<Object> listCategories() {
		return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCategory(@PathVariable(value = "id") UUID id ){
		Optional<CategoryModel> categoryModelOptional = categoryService.findById(id);
		if(!categoryModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
		};
		return ResponseEntity.status(HttpStatus.OK).body(categoryModelOptional.get());
	}
	
	@PostMapping
	public ResponseEntity<Object> saveCategory(@RequestBody @Valid CategoryDto categoryDto){
		
		var categoryModel = new CategoryModel();
		BeanUtils.copyProperties(categoryDto, categoryModel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(categoryModel));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCategory(@PathVariable(value="id") UUID id, @RequestBody @Valid CategoryDto categoryDto){
		Optional<CategoryModel> categoryModelOptional = categoryService.findById(id);
		if(!categoryModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
		};
		var categoryModel = new CategoryModel();
		BeanUtils.copyProperties(categoryDto, categoryModel);
		categoryModel.setId_category(categoryModelOptional.get().getId_category());
		categoryModel.setName(categoryDto.getName());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(categoryService.save(categoryModel));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") UUID id){
		Optional<CategoryModel> categoryModelOptional = categoryService.findById(id);
		if(!categoryModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não existe");
		};
		
		categoryService.delete(categoryModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Categoria deletada com sucesso");
	}

}
