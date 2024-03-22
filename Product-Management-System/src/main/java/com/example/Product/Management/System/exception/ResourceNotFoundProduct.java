package com.example.Product.Management.System.exception;

public class ResourceNotFoundProduct extends RuntimeException{
	private int resourceId;
	private String resourceName;
	public ResourceNotFoundProduct(int id, String name) {
		this.resourceId = id;
		this.resourceName = name;
	}
}
