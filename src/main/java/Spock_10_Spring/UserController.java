package Spock_10_Spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserFacade userFacade;

    UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("/")
    User addUser(User userToAdd) {
        return userFacade.add(userToAdd);
    }
}
