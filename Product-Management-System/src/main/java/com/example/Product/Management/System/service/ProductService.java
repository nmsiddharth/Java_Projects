package com.example.Product.Management.System.service;

import java.util.List;

import com.example.Product.Management.System.DTO.ProductDTO;

public interface ProductService {
	ProductDTO addProduct(ProductDTO productDTO);
	List<ProductDTO> getAllProducts();
    ProductDTO getProductById(int id);
    ProductDTO updateProduct(int id, ProductDTO productDTO);
    void deleteProductById(int id);
}
