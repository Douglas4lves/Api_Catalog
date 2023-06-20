package com.api.catalog.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, unique = true, length = 50)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER) 
	private List<ProductModel> products;
	
	

	public CategoryModel() {
		super();
	}
	
	

	public CategoryModel(String name, List<ProductModel> products) {
		super();
		this.name = name;
		this.products = products;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "CategoryModel [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
	
	
	
}
