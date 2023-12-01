package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//this handles user authentication, creating username and password and then checking if the username and password both match
public class UserAuthentication {
    public UserAuthentication(String username, String password) throws IOException {
        File passFile = new File(username + ".txt");
        if (!passFile.createNewFile()) {
            throw new IOException("Username already exists");
        } else {
            FileWriter passWriter = new FileWriter(passFile);
            passWriter.write(password);
            passWriter.close();
        }
    }

    public boolean login(String username, String password) throws FileNotFoundException {
        File passFile = new File(username + ".txt");
        if (!passFile.exists()) {
            return false;
        }
        Scanner passReader = new Scanner(passFile);
        String pass = passReader.nextLine();
        passReader.close();
        return pass.equals(password);
    }
}
