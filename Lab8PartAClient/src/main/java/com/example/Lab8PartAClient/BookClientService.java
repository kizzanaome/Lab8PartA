package com.example.Lab8PartAClient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BookClientService {
    private final  String BASE_URL ="http://localhost:8081/api/books";
    private final RestTemplate restTemplate = new RestTemplate();

    //Add Book
    public void addBook( Book book){
        try{
            ResponseEntity<Book> response = restTemplate.postForEntity(BASE_URL,book, Book.class );
            System.out.println("Book added" + response.getBody());
        }catch (Exception e){
            System.out.println("Failed to add Book" + e.getMessage());
        }

    }

    //UpdateBook
    public void updateBook(Book book){
        restTemplate.put(BASE_URL, book);
        System.out.println("Book updated successfully");
    }

    public void deleteBook(String isbn){
        restTemplate.delete(BASE_URL+ "/" + isbn, Book.class);
        System.out.println(" Book deleted successfully!");
    }

    public  void getBook(String isbn){
        Book book  = restTemplate.getForObject(BASE_URL + "/" +isbn, Book.class);
        System.out.println("Book details: " +book);
    }

    public void getAllBooks(){
        ResponseEntity<Book[]> response = restTemplate.getForEntity(BASE_URL, Book[].class);
        List<Book> books =  Arrays.asList(response.getBody());
        System.out.println("All books");
        books.forEach(System.out::println);

    }

    public void searchBooks(String author){
        ResponseEntity<Book[]> response = restTemplate.getForEntity(BASE_URL +"/search?author=" +author, Book[].class);
        List<Book> books = Arrays.asList(response.getBody());
        System.out.println("Search results for author: " + author);
        books.forEach(System.out::println);
    }



}
