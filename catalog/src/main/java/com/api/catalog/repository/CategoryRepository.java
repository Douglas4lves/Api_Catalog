package com.api.catalog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.catalog.model.CategoryModel;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, UUID>{

}
