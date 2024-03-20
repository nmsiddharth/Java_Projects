package com.example.BookApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookApi.DTO.BookDTO;
import com.example.BookApi.entity.Book;
import com.example.BookApi.exception.ResourceNotFoundException;
import com.example.BookApi.repository.BookRepository;

@Service
public class BookApiServiceImpl implements BookApiService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public BookDTO addBook(BookDTO bookDto) {
		Book book = this.modelMapper.map(bookDto, Book.class);
		Book savedBook = this.bookRepository.save(book);
		return this.modelMapper.map(savedBook, BookDTO.class);
	}

	@Override
	public BookDTO updateBook(int id, BookDTO bookDto) {
		Book book = this.bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id,"Book"));
		book.setBookName(bookDto.getBookName());
		book.setAuthor(bookDto.getAuthor());
		book.setBookPrice(bookDto.getBookPrice());
		Book updatedBook = this.bookRepository.save(book);
		
		return this.modelMapper.map(updatedBook, BookDTO.class);
	}

	@Override
	public List<BookDTO> getAll() {
		List<Book> books = this.bookRepository.findAll();
//		return books.stream().map(book->this.modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
		
		// OR
		
		List<BookDTO> bookDTOs = new ArrayList<>();
		
		for(Book book:books) {
			BookDTO bookDto = this.modelMapper.map(book, BookDTO.class);
			bookDTOs.add(bookDto);
		}
		return bookDTOs;
	}

	
	@Override
	public BookDTO getBookById(int id) {
		Book book = this.bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id, "book"));
		return this.modelMapper.map(book, BookDTO.class);
	}

	@Override
	public void deleteBookById(int id) {
		Book book = this.bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id, "book"));
		this.bookRepository.delete(book);
	}

	@Override
	 public List<BookDTO> getBookByName(String bookName) {
        Optional<List<Book>> optionalBooks = this.bookRepository.findByBookName(bookName);

        if (optionalBooks.isPresent()) {
            List<BookDTO> bookDTOs = new ArrayList<>();
            List<Book> books = optionalBooks.get();

            for (Book book : books) {
                BookDTO bookDto = this.modelMapper.map(book, BookDTO.class);
                bookDTOs.add(bookDto);
            }
            return bookDTOs;
        } else {
            // Handle case when no books are found
            return new ArrayList<>(); // or throw an exception, log, etc.
        }
    }

}
