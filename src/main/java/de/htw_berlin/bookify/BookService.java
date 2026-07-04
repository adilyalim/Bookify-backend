package de.htw_berlin.bookify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository repo;

    public List<Book> getAll() {
        return (List<Book>) repo.findAll();
    }

    public Book save(Book book) {
        return repo.save(book);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public Book update(Long id, Book updatedBook) {
        Book book = repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPages(updatedBook.getPages());
        return repo.save(book);
    }
}
