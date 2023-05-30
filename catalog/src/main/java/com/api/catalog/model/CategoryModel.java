package com.api.catalog.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private UUID id_category;
	
	@Column(nullable = false, unique = true, length = 50)
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<ProductModel> products;

	public UUID getId_category() {
		return id_category;
	}

	public void setId_category(UUID id_category) {
		this.id_category = id_category;
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
	
	
	
}
