package com.example.BookApi.controller;

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

import com.example.BookApi.DTO.BookDTO;
import com.example.BookApi.service.BookApiService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class BookController {
	
	@Autowired
	private BookApiService bookApiService;
	
	@PostMapping("/books")
	public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookDto){
	 BookDTO bookDTO = this.bookApiService.addBook(bookDto);
	 return new ResponseEntity<>(bookDTO,HttpStatus.CREATED);
	}
	
	@GetMapping("/books/id/{bookId}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable int bookId){
	BookDTO bookDTO = this.bookApiService.getBookById(bookId);
	 return new ResponseEntity<>(bookDTO,HttpStatus.FOUND);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<BookDTO>> getAllBook(){
		List<BookDTO> bookDTO = this.bookApiService.getAll();
		 return new ResponseEntity<>(bookDTO,HttpStatus.OK);
	}
	
	@GetMapping("/books/name/{bookName}")
	public ResponseEntity<List<BookDTO>> getBookByName(@PathVariable String bookName){
		List<BookDTO> bookDTO = this.bookApiService.getBookByName(bookName);
		return new ResponseEntity<>(bookDTO,HttpStatus.OK);
	}
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable int bookId, @RequestBody BookDTO bookDTO){
		BookDTO bookDto = this.bookApiService.updateBook(bookId, bookDTO);
		 return new ResponseEntity<>(bookDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable int bookId){
		 this.bookApiService.deleteBookById(bookId);
		 return new ResponseEntity<>("Book deleted successfully",HttpStatus.OK);
		} 
	
}
