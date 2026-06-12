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
}
