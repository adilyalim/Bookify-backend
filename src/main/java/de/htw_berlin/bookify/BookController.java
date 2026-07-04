package de.htw_berlin.bookify;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return service.getAll();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return service.save(book);
    }
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.delete(id);
    }
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return service.update(id, updatedBook);
    }
}
