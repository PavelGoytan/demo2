package by.hoitan.demo2.service;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

public class Auth extends Authenticator {

    private final PasswordAuthentication authentication;

    public Auth(String username, String password){
        this.authentication = new  PasswordAuthentication(username, password);
    }

    protected PasswordAuthentication getPasswordAuthentication(){
        return authentication;
    }

}
