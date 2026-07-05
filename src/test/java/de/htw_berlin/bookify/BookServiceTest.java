package de.htw_berlin.bookify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void save_setsDefaultShelfWhenMissing() {
        Book book = new Book("Sapiens", "Yuval Noah Harari", 443, null, null, null, null);
        when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Book saved = bookService.save(book);

        assertThat(saved.getShelf()).isEqualTo("Möchte ich lesen");
    }

    @Test
    void getAll_returnsBooksFromRepository() {
        Book book = new Book("1984", "George Orwell", 328, null, "", null, "Gelesen");
        when(bookRepository.findAll()).thenReturn(List.of(book));

        List<Book> books = bookService.getAll();

        assertThat(books).hasSize(1);
        verify(bookRepository).findAll();
    }

    @Test
    void delete_callsRepositoryWithCorrectId() {
        bookService.delete(7L);

        verify(bookRepository).deleteById(7L);
    }
}