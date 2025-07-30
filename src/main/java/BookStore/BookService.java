package BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{
    @Autowired
    private  BookRepository bookRepository;

    public Book addBook(Book book){
        if(bookRepository.existsById(book.getIsbn())){
            throw new BookAlreadyExistsException("Book with ISBN " + book.getIsbn() + " already exists");
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }

    public Book getBook(String isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }
}
