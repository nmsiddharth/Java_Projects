package com.example.Product.Management.System.exception;

public class ResoureNotFoundCategory extends RuntimeException {
	private int resourceId;
	private String resourceName;
	public ResoureNotFoundCategory(int id, String name) {
		this.resourceId = id;
		this.resourceName = name;
	}
}
