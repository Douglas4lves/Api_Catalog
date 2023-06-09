package com.api.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.catalog.model.CategoryModel;
import com.api.catalog.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional
	public CategoryModel save(CategoryModel categoryModel) {
		return categoryRepository.save(categoryModel); 
	}
	
	
	public List<CategoryModel> findAll(){
		return categoryRepository.findAll();
	}
	
	public Optional<CategoryModel> findById(Integer id){
		return categoryRepository.findById(id);
	}
	
	
	
	
	@Transactional
	public void delete(CategoryModel categoryModel) {
		categoryRepository.delete(categoryModel);
	}
	
}
