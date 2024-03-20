package com.example.BookApi.exception;

public class ResourceNotFoundException extends RuntimeException {
	private int resourceId;
	private String resourceName;
	public ResourceNotFoundException(int id, String bookName) {
		this.resourceId = id;
		this.resourceName = bookName;
	}
}
