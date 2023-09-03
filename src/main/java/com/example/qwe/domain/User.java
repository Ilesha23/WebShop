package com.example.qwe.domain;

public class User {
    private String login;
    private String pass;
    private boolean advertising;

    public User(){}

    public User(String login, String pass, boolean advertising) {
        this.login = login;
        this.pass = pass;
        this.advertising = advertising;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public boolean isAdvertising() {
        return advertising;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAdvertising(boolean advertising) {
        this.advertising = advertising;
    }
}
