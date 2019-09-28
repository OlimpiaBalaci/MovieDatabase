package com.balacio;

import com.balacio.constants.Constants;
import com.balacio.db.DatabaseWrapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        //old
        //region read data from terminal
    /*    // write your code here
        //System.out.println("test");
        Connection connection = null; //used to open
        try {
            connection = DriverManager.getConnection(Constants.DB_DRIVER_IMPLEMENTATION + "://localhost:3306/imdb",
                    Constants.DB_USERNAME, Constants.DB_PASSWORD);
            System.out.println("Connection Succesfully!");


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        //endregion*/
        DatabaseWrapper databasewrapper = new DatabaseWrapper();
        Connection connection = null;
        try {
            connection = databasewrapper.createConnection(
                    Constants.DB_DRIVER_IMPLEMENTATION +"://"+ Constants.DB_CONN_STRING,
                            Constants.DB_USERNAME, Constants.DB_PASSWORD
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
                //statement created from JDBC connection
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE movies(id INTEGER PRIMARY KEY AUTO_INCREMENT, name TEXT NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
