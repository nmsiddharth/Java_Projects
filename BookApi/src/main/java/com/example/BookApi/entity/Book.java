package com.example.BookApi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="bookApi")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	
	@Column(length=10)
	@NotEmpty(message="Book name should not be null")
	private String bookName;
	
	@NotEmpty(message="Author should not be empty")
	private String author;
	private double bookPrice;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Book(int bookId, @NotEmpty(message = "Book name should not be null") String bookName,
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
