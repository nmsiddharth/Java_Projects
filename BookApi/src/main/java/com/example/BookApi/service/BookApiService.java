package com.example.BookApi.service;

import java.util.List;

import com.example.BookApi.DTO.BookDTO;

public interface BookApiService {
	BookDTO addBook(BookDTO bookDto);
	BookDTO updateBook(int id,BookDTO bookDto);
	List<BookDTO> getAll();
	List<BookDTO> getBookByName(String bookName);
	BookDTO getBookById(int id);
	void deleteBookById(int id);
}
