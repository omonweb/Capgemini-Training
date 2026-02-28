package com.capgemini.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserRepository {

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbcrud",
                    "root",
                    "root"
            );
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
