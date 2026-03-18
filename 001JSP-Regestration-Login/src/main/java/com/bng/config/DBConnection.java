package com.bng.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        Class.forName(DbUtil.getDriver());
        return DriverManager.getConnection(
        		DbUtil.getUrl(),
        		DbUtil.getUsername(),
        		DbUtil.getPassword()
        );
    }
    
}