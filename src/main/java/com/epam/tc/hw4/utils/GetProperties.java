package com.epam.tc.hw4.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
    private String username;
    private String password;
    private String usernameText;

    private void getPropertyFromFile() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/user.properties");
            property.load(fis);

            username = property.getProperty("usernameProp");
            password = property.getProperty("passwordProp");
            usernameText = property.getProperty("usernameTextProp");
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public String getUsernameProp() {
        getPropertyFromFile();
        return username;
    }

    public String getPasswordProp() {
        getPropertyFromFile();
        return password;
    }

    public String getUsernameTextProp() {
        getPropertyFromFile();
        return usernameText;
    }
}

