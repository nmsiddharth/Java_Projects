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

import com.example.Product.Management.System.DTO.ProductDTO;
import com.example.Product.Management.System.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	  @Autowired
	    private ProductService productService;

	  @PostMapping("/products")
	    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
	        ProductDTO savedProduct = this.productService.addProduct(productDTO);
	        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	    }
	  
	  @GetMapping("/products")
	    public ResponseEntity<List<ProductDTO>> getAllProducts() {
	        List<ProductDTO> productDTOList = this.productService.getAllProducts();
	        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
	    }

	  @GetMapping("/products/{id}")
	    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
	        ProductDTO productDTO = this.productService.getProductById(id);
	        return new ResponseEntity<>(productDTO, HttpStatus.OK);
	    }
	  
	  @PutMapping("/products/{id}")
	    public ResponseEntity<ProductDTO> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
	        ProductDTO updatedProduct = this.productService.updateProduct(id, productDTO);
	        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	    }
	  
	  @DeleteMapping("/products/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
	        this.productService.deleteProductById(id);
	        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
	    }
}
