package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Authntication {
    UserRepository userRepository;



    public Authntication(UserRepository userRepository) throws FileNotFoundException {
        this.userRepository = userRepository;
    }

     User authenticate(String username, String password) throws IOException {
         BufferedReader br = new BufferedReader(new FileReader("users.txt"));
        String line = br.readLine();;

        while (line != null) {
            String[] parts = line.split(";");
            if (parts[0].equals(username) && parts[2].equals(DigestUtils.sha256Hex(password))) {
                User user = new User(parts[0]);
                user.role = parts[1];
                return user;
            }
            line = br.readLine();
        }
        return null;
    }
}
