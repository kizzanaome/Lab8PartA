package com.example.Lab8PartAClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Lab8PartAClientApplication implements CommandLineRunner {

	@Autowired
	private  BookClientService bookClientService;

	public static void main(String[] args) {
		SpringApplication.run(Lab8PartAClientApplication.class, args);
	}


	@Override
	public void run(String... args) {
		bookClientService.addBook(new Book("101", "John Doe", "Spring Boot Basics", 29.99));
		// Add books
		bookClientService.addBook(new Book("101", "John Doe", "Spring Boot Basics", 29.99));
		bookClientService.addBook(new Book("102", "Jane Smith", "Advanced Spring Boot", 39.99));

		// Get all books
		bookClientService.getAllBooks();

		// Get a specific book
		bookClientService.getBook("101");

		// Search books by author
		bookClientService.searchBooks("Jane");

		// Update a book
		bookClientService.updateBook(new Book("101", "John Doe", "Spring Boot Basics - Updated", 35.0));

		// Delete a book
		bookClientService.deleteBook("102");

		// Final list
		bookClientService.getAllBooks();

	}
}