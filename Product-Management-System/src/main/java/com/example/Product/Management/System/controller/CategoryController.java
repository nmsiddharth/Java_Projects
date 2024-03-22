package com.example.Product.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product.Management.System.DTO.CategoryDTO;
import com.example.Product.Management.System.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/categories")
	public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO categoryDTO){
		CategoryDTO savedCategory = this.categoryService.addCategory(categoryDTO);
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDTO>> getAll(){
		List<CategoryDTO> categoryList = this.categoryService.getAllCategories();
		return new ResponseEntity<>(categoryList,HttpStatus.OK);
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable int id){
		CategoryDTO categoryDTO = this.categoryService.getCategoryById(id);
		return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@PathVariable int id, @RequestBody CategoryDTO categoryDTO){
		CategoryDTO updateCategory = this.categoryService.updateCategory(id, categoryDTO);
		return new ResponseEntity<CategoryDTO>(updateCategory,HttpStatus.OK);
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id){
		this.categoryService.deleteCategoryById(id);
		return new ResponseEntity<>("Category Deleted Successfully",HttpStatus.OK);
	}
	
}
