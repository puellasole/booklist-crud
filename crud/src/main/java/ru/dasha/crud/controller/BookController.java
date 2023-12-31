package ru.dasha.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.dasha.crud.model.Book;
import ru.dasha.crud.service.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public String findAll(Model model) {
		List<Book> books = bookService.findAll();
		model.addAttribute("books",books);
		return "book-list";
	}
	
	@GetMapping("/book-create")
	public String createBookForm(Book book) {
		return "book-create";
	}
	
	@PostMapping("/book-create")
	public String createBook(Book book) {
		bookService.saveBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/book-delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteById(id);
		return "redirect:/books";
	}
	
	@GetMapping("/book-update/{id}")
	public String updateBookForm(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book",book);
		return "/book-update";
	}
	
	@PostMapping("/book-update/{id}")
	public String updateBook(@PathVariable("id") Long id, Book updbook) {
		Book book = bookService.findById(id);
		book.setTitle(updbook.getTitle());
		book.setAuthor(updbook.getAuthor());
		bookService.saveBook(book);
		return "redirect:/books";
	}

}
