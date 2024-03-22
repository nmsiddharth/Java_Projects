package com.example.Product.Management.System.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Product.Management.System.DTO.CategoryDTO;
import com.example.Product.Management.System.entity.Category;
import com.example.Product.Management.System.exception.ResourceNotFoundProduct;
import com.example.Product.Management.System.exception.ResoureNotFoundCategory;
import com.example.Product.Management.System.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDTO) {
		Category category = this.modelMapper.map(categoryDTO, Category.class);
		Category saveCategory = this.categoryRepository.save(category);
		return this.modelMapper.map(saveCategory, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		List<Category> categories = this.categoryRepository.findAll();
		return categories.stream().map(category-> this.modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
	}

	@Override
	public CategoryDTO getCategoryById(int id) {
		Category category = this.categoryRepository.findById(id).orElseThrow(()-> new ResoureNotFoundCategory(id, "Category"));
		return this.modelMapper.map(category, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(int id, CategoryDTO categoryDTO) {
		Category category = this.categoryRepository.findById(id).orElseThrow(()-> new ResoureNotFoundCategory(id, "Category"));
		category.setCategoryName(categoryDTO.getCategoryName());
		category.setProducts(categoryDTO.getProducts());
		
		Category saveCategory = this.categoryRepository.save(category);
		return this.modelMapper.map(saveCategory, CategoryDTO.class);
	}

	@Override
	public void deleteCategoryById(int id) {
		Category category = this.categoryRepository.findById(id).orElseThrow(()-> new ResoureNotFoundCategory(id, "Category"));
		this.categoryRepository.delete(category);
	}
}
