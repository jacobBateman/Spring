package org.example;

import java.util.ArrayList;

public class UserRepository implements IUserRepository {
    ArrayList<User> users = new ArrayList<>();
    @Override
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public void save() {

    }
}
