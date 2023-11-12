package ru.dasha.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.dasha.crud.model.Book;
import ru.dasha.crud.repository.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book findById(Long id) {
		return bookRepository.getOne(id);
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}
}
