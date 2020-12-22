package com.example.dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
    private Connection conn=null;
    public DBCon(){
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
        } catch (Exception e){
            System.out.println("couldn't connect");
        }
    }

    public Connection getConnection(){
        return conn;
    }
}
