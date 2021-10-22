package shop;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public abstract class user
{
    public String email;
    public String password; 

    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public user() {
        this.email = "Raghad";
        this.password = "r123";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
