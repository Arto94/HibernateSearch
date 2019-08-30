package am.itspace.hibernate_search;

import am.itspace.hibernate_search.model.Author;
import am.itspace.hibernate_search.model.Book;
import am.itspace.hibernate_search.model.User;
import am.itspace.hibernate_search.repository.AuthorRepository;
import am.itspace.hibernate_search.repository.BookRepository;
import am.itspace.hibernate_search.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class HibernateSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateSearchApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            User user = User.builder()
                    .name("name")
                    .surname("surname")
                    .phoneNumber("9999")
                    .build();
            userRepository.save(user);
            Author author = Author.builder()
                    .name("Dmitriy Gluxovski")
                    .build();
            authorRepository.save(author);
            Set<Author> authors = new HashSet<>();
            authors.add(author);
            Book book = Book.builder()
                    .title("Metro 2033")
                    .subtitle("metro")
                    .publicationDate(new Date())
                    .authors(authors)
                    .build();
            bookRepository.save(book);
        };
    }

}
