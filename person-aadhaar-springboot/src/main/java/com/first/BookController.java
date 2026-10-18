package com.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookRepo db;

	// Save Book
	@PostMapping("/book/save")
	public String saveBook(@RequestBody Book b) {

		db.save(b);

		return "Book Data Saved";
	}

	// Get Book By ID
	@GetMapping("/book/{bid}")
	public Book getBookById(@PathVariable int bid) {

		return db.findById(bid).get();
	}

	// Get All Books
	@GetMapping("/book/all")
	public List<Book> getAllBooks() {

		return db.findAll();
	}

	// Update Book
	@PutMapping("/book/update")
	public String updateBook(@RequestBody Book b) {

		db.save(b);

		return "Book Data Updated";
	}

	// Delete Book
	@DeleteMapping("/book/delete/{bid}")
	public String deleteBook(@PathVariable int bid) {

		db.deleteById(bid);

		return "Book Data Deleted";
	}

	// Find Book By Title
	@GetMapping("/book/title/{title}")
	public List<Book> findByTitle(@PathVariable String title) {

		return db.findByTitle(title);
	}

	// Find Book By Price
	@GetMapping("/book/price/{price}")
	public List<Book> findByPrice(@PathVariable double price) {

		return db.findByPrice(price);
	}

	// Find Book By Author
	@GetMapping("/book/author/{author}")
	public List<Book> findByAuthor(@PathVariable String author) {

		return db.findByAuthor(author);
	}
}
