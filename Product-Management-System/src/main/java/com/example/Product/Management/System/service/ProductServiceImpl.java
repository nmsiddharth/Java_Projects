package com.example.Product.Management.System.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Product.Management.System.DTO.ProductDTO;
import com.example.Product.Management.System.entity.Product;
import com.example.Product.Management.System.exception.ResourceNotFoundProduct;
import com.example.Product.Management.System.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		Product product = this.modelMapper.map(productDTO, Product.class);
	    Product savedProduct = this.productRepository.save(product);
        return this.modelMapper.map(savedProduct, ProductDTO.class);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		 List<Product> products = this.productRepository.findAll();
	        return products.stream()
	                .map(product -> this.modelMapper.map(product, ProductDTO.class))
	                .collect(Collectors.toList());
	}

	@Override
	public ProductDTO getProductById(int id) {
		Product product = this.productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundProduct(id, "Product"));
		return this.modelMapper.map(product, ProductDTO.class);
	}

	@Override
	public ProductDTO updateProduct(int id, ProductDTO productDTO) {
		Product product = this.productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundProduct(id, "Product"));
		product.setProductName(productDTO.getProductName());
		product.setProductPrice(productDTO.getProductPrice());
		product.setCategory(productDTO.getCategory());
		Product savedProduct = this.productRepository.save(product);
		return this.modelMapper.map(savedProduct, ProductDTO.class); 
	}

	@Override
	public void deleteProductById(int id) {
		Product product = this.productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundProduct(id, "Product"));
		this.productRepository.delete(product);
	}

}
