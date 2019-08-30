package am.itspace.hibernate_search.service;

import am.itspace.hibernate_search.model.Book;
import am.itspace.hibernate_search.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookSearch bookSearch;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> search(String text) {
        return bookSearch.searchBooks(text);
    }

}
