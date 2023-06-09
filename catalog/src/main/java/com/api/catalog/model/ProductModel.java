package com.api.catalog.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private Integer id;
	
	@Column(nullable = false, length = 130)
	private String name;
	
	@Column(nullable = false, unique = true)
	private int cod_product;
	
	@Column(length = 300)
	private String imageurl;
	
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryModel category;
 

	public ProductModel() {
		super();
	}

	

	public ProductModel(String name, int cod_product, String imageurl, CategoryModel category) {
		super();
		this.name = name;
		this.cod_product = cod_product;
		this.imageurl = imageurl;
		this.category = category;
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



	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", cod_product=" + cod_product + ", imageurl=" + imageurl
				+ ", category=" + category + "]";
	}
	
	
	
	
	
	
	
	
}
