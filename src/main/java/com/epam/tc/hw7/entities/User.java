package com.epam.tc.hw7.entities;

import com.epam.tc.hw3.library.utils.GetProperties;

public class User {

    static GetProperties getProperties = new GetProperties();
    public static final User ROMAN = new User(
        getProperties.getUsernameProp(),
        getProperties.getPasswordProp(),
        getProperties.getUsernameTextProp());

    private final String name;
    private final String password;
    private final String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
