package am.itspace.hibernate_search.service;

import am.itspace.hibernate_search.model.User;
import am.itspace.hibernate_search.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserSearch userSearch;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> search(String text) {
        return userSearch.searchUsers(text);
    }

}
