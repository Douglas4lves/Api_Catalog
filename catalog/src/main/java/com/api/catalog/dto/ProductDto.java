package com.api.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDto {
	
	
	
	@NotBlank(message = "O campo não poder ser vazio ou nulo")
	private String name;
	
	@NotNull(message = "o campo não pode ser nulo")
	private int cod_product;
	
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

	

	
	
	
}
