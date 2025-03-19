package org.example;

public class Authntication {
    UserRepository userRepository;

    public Authntication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    boolean authenticate(String username, String password) {
        for (User user : userRepository.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) return true;
        }
        return false;
    }
}
