package com.example.ianc.powerofwords;

import android.net.Uri;

import java.net.URI;

/**
 * Created by Ian C on 16/03/2015.
 */
public class User {

    private int id;
    private String username;
    private String password;

    public User(){

    }

    public User(String _username, String _password){
        username = _username;
        password = _password;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id){
        id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String _username) {
        username = _username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        password = _password;
    }

}
