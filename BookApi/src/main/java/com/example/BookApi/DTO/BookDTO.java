package com.example.BookApi.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class BookDTO {
	private int bookId;
	@Column(length=10)
	@NotEmpty(message="Book name should not be null")
	private String bookName;
	@NotEmpty(message="Author should not be empty")
	private String author;
	private double bookPrice;
	
	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public BookDTO(int bookId, @NotEmpty(message = "Book name should not be null") String bookName,
			@NotEmpty(message = "Author should not be empty") String author, double bookPrice) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookPrice = bookPrice;
	}
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", bookPrice=" + bookPrice
				+ "]";
	}
	
}
