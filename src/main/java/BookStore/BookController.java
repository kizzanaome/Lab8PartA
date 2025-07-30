package BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;



    @PostMapping("/greeting")
    public ResponseEntity<?> addBook(@RequestBody Book book){

        try {
            return  new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);

        }catch (BookAlreadyExistsException ex){
            return  new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping
    public  ResponseEntity<Book> updateBook(@RequestBody Book book){
        return  ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBook(isbn));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String author) {
        return ResponseEntity.ok(bookService.searchBooks(author));
    }
}
