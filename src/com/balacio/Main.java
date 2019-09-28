package com.balacio;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //System.out.println("test");
        Connection connection; //used to open
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306",
                    "root", "maxim11forever");
            System.out.println("Connection Succesfully!");


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
    }
}
