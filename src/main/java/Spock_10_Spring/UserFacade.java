package Spock_10_Spring;

import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    public User add(User userToAdd) {
        userToAdd.setId(1L);
        return userToAdd;
    }

}
