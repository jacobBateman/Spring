package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.ArrayList;

public class UserRepository implements IUserRepository {
     static ArrayList<User> users = new ArrayList<>();
    @Override
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


     static void addUser(User user) {
        users.add(user);
        //save(user);
    }
    @Override
    public ArrayList<User> getUsers() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("users.txt"));
        String line = br.readLine();
        while (line != null) {
            String[] parts = line.split(";");
            System.out.println(parts[0]);
            line = br.readLine();
        }
        return users;
    }

    @Override
    public void save(User user) {
        //zapisywać userów do pliku
        String path = "users.txt";
        String dane = user.getUsername() + ";" + user.getRole() + ";" + user.getPassword();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.newLine();
            bw.write(dane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
