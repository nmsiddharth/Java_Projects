package com.example.BookApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookApi.DTO.BookDTO;
import com.example.BookApi.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	Optional<List<Book>> findByBookName(String bookName);
}
