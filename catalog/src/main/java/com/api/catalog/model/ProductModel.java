package com.api.catalog.model;

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
	
	@Column(name = "cod_product",nullable = false, unique = true)
	private int codProduct;
	
	@Column(length = 300)
	private String imageurl;
	
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryModel category;
 

	public ProductModel() {
		super();
	}

	

	public ProductModel(String name, int codProduct, String imageurl, CategoryModel category) {
		super();
		this.name = name;
		this.codProduct = codProduct;
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

	
	public int getCodProduct() {
		return codProduct;
	}

	public void setCodProduct(int codProduct) {
		this.codProduct = codProduct;
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
		return "ProductModel [id=" + id + ", name=" + name + ", cod_product=" + codProduct + ", imageurl=" + imageurl
				+ ", category=" + category + "]";
	}
	
	
	
	
	
	
	
	
}
