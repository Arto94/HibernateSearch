package am.itspace.hibernate_search.endpoint;

import am.itspace.hibernate_search.model.User;
import am.itspace.hibernate_search.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserEndpoint {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam(value = "text") String text) {
        return ResponseEntity.ok(userService.search(text));
    }

}
