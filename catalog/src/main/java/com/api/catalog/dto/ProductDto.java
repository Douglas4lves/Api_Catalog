package com.api.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDto {
	
	
	
	@NotBlank(message = "O campo não poder ser vazio ou nulo")
	private String name;
	
	@NotNull(message = "o campo não pode ser nulo")
	private int codProduct;
	
	@NotBlank
	private String imageurl;
	
	
	private Integer category;

	

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
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

	

	
	
	
}
