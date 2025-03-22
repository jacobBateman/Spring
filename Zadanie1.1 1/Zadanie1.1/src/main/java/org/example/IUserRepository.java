package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IUserRepository {
    User getUser(String username);
    ArrayList<User> getUsers() throws IOException;
    void save(User user);
}
