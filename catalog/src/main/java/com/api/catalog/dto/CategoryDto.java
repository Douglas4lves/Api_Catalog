package com.api.catalog.dto;




import jakarta.validation.constraints.NotBlank;

public class CategoryDto {
	
	
	@NotBlank(message ="Campo nome não pode ser vazio ou nulo")
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
