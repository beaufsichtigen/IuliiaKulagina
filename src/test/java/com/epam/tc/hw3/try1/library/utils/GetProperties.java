package com.epam.tc.hw3.try1.library.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class GetProperties {


    private String username;
    private String password;

    public GetProperties() {
    }

    private void getPropertyFromFile() {

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/test/resources/user.properties");
            property.load(fis);

            username = property.getProperty("usernameProp");
            password = property.getProperty("passwordProp");


            //            System.out.println("HOST: " + host
            //                    + ", LOGIN: " + login);

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


}


//
//    public String  userName;
//    public String  password;
//    Properties properties = new Properties();
//    File file = new File("user.properties");
//
//    public GetProperties() {    }
//
//
//
//    public String getUserNameProp() {
//        String userName = (String) properties.get("usernameProp");
//
//        return userName;
//    }
//
////    public static String getPasswordProp() {
////        String password = getProperty("passwordProp");
////
////        return password;
////    }
//
//    public static void main(String[] args) {
//
//        GetProperties properties = new GetProperties();
//        System.out.println(properties.getUserNameProp());
//        //System.out.println(getPasswordProp());
//    }
//
//}
