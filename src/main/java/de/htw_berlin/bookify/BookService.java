package de.htw_berlin.bookify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public List<Book> getAll() {
        return repo.findAll();
    }

    public Book save(Book book) {
        if (book.getShelf() == null || book.getShelf().isBlank()) {
            book.setShelf("Möchte ich lesen");
        }

        if (book.getKommentar() == null) {
            book.setKommentar("");
        }

        return repo.save(book);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Book update(Long id, Book updatedBook) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPages(updatedBook.getPages());
        book.setBewertung(updatedBook.getBewertung());
        book.setKommentar(updatedBook.getKommentar());
        book.setThumbnail(updatedBook.getThumbnail());
        book.setShelf(updatedBook.getShelf());

        if (book.getShelf() == null || book.getShelf().isBlank()) {
            book.setShelf("Want to Read");
        }

        if (book.getKommentar() == null) {
            book.setKommentar("");
        }

        return repo.save(book);
    }
}