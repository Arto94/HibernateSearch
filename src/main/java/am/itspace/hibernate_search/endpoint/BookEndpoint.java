package am.itspace.hibernate_search.endpoint;

import am.itspace.hibernate_search.model.Book;
import am.itspace.hibernate_search.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookEndpoint {

    private final BookService bookService;

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam(value = "text") String text) {
        return ResponseEntity.ok(bookService.search(text));
    }

}
