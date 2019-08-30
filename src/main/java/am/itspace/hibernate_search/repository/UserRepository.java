package am.itspace.hibernate_search.repository;

import am.itspace.hibernate_search.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
