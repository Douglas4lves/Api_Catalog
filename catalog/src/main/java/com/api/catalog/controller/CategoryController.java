package com.api.catalog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping
	public ResponseEntity<Object> listCategories() { 
		List<CategoryModel> lista = categoryService.findAllCategories();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryModel> getOneCategory(@PathVariable(value = "id") Integer id ){		
		CategoryModel categoryModelOptional = categoryService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(categoryModelOptional);
	}
	
	@PostMapping
	public ResponseEntity<Object> saveCategory(@RequestBody @Valid CategoryDto categoryDto){
		var categoryModel = new CategoryModel();
		BeanUtils.copyProperties(categoryDto, categoryModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(categoryModel));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCategory(@PathVariable(value="id") Integer id, @RequestBody @Valid CategoryDto categoryDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getAllErrors().stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}
		CategoryModel categoryModelOptional = categoryService.findById(id);
		var categoryModel = new CategoryModel();
		BeanUtils.copyProperties(categoryDto, categoryModel);
		categoryModel.setId(categoryModelOptional.getId());	
		return ResponseEntity.status(HttpStatus.OK).body(categoryService.save(categoryModel));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CategoryModel> deleteCategory(@PathVariable(value = "id") Integer id){
		CategoryModel categoryModelOptional = categoryService.findById(id);
		categoryService.delete(categoryModelOptional);
		return ResponseEntity.status(HttpStatus.OK).body(categoryModelOptional);
	}

}
