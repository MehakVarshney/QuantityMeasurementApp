package com.QuantityMeasurementApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

    private static Connection connection;

    public static Connection getConnection(){

        try{

            if(connection==null ||
                    connection.isClosed()){

                connection =
                        DriverManager.getConnection(
                                ApplicationConfig.get("db.url"),
                                ApplicationConfig.get("db.user"),
                                ApplicationConfig.get("db.password"));

            }

        }
        catch(SQLException e){

            throw new RuntimeException(
                    "DB connection failed");

        }

        return connection;

    }

}