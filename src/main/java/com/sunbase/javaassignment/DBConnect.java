package com.sunbase.javaassignment;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static Connection conn;

    public static Connection getConn() {
        try{
            System.out.println("i am in DBConnect");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sunbase","root","12345");
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return conn;
    }
}
