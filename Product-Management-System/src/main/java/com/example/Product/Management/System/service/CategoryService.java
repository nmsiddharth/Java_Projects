package com.example.Product.Management.System.service;

import java.util.List;

import com.example.Product.Management.System.DTO.CategoryDTO;

public interface CategoryService {
	 CategoryDTO addCategory(CategoryDTO categoryDTO);
	 List<CategoryDTO> getAllCategories();
	 CategoryDTO getCategoryById(int id);
	 CategoryDTO updateCategory(int id, CategoryDTO categoryDTO);
	 void deleteCategoryById(int id);
}
