package am.itspace.hibernate_search.repository;

import am.itspace.hibernate_search.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
