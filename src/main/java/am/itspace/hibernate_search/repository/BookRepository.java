package am.itspace.hibernate_search.repository;

import am.itspace.hibernate_search.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
