package com.api.catalog.dto;




import com.api.catalog.model.CategoryModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDto {
	
	
	
	@NotBlank
	private String name;
	
	@NotNull
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
