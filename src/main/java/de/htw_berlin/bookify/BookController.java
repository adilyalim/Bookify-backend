package de.htw_berlin.bookify;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BookController {


    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1L, "Der kleine Prinz", "Antoine de Saint-Exupery",96),
                new Book(2L, "1984", "George Orwell", 384)
        );
    }
}
