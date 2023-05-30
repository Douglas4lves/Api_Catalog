package com.api.catalog.model;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_product;
	
	@Column(nullable = false, length = 130)
	private String name;
	
	@Column(nullable = false, unique = true)
	private int cod_product;
	
	@Column(length = 300)
	private String imageurl;
	
	@ManyToOne
	@JoinColumn(name = "id_category")
	private CategoryModel category;

	public UUID getId_product() {
		return id_product;
	}

	public void setId_product(UUID id_product) {
		this.id_product = id_product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCod_product() {
		return cod_product;
	}

	public void setCod_product(int cod_product) {
		this.cod_product = cod_product;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	
	
	
	
	
	
	
	
}
