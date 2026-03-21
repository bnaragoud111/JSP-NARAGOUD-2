package com.bng.config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class DBConnection {

    public static Connection getConnection() throws Exception {
  	 Properties prop = new Properties();
  	 /*
   	 String driver = prop.getProperty("db.driver");
  	 String url = prop.getProperty("db.url");
     String username = prop.getProperty("db.username");
     String password = prop.getProperty("db.password");
     */
      try {
        FileInputStream fis = new FileInputStream("C:/Users/ADMIN/Documents/Repository/Backend/ADVANCED JAVA/JSP-NARAGOUD-2/001JSP-Regestration-Login/src/resources/db.properties");
        prop.load(fis);
        prop.list(System.out);
      }
      catch (Exception e) {
          e.printStackTrace();
      }
      String driver = prop.getProperty("db.driver");
      //String driver = "com.mysql.cj.jdbc.Driver";
   System.out.println("driver+++++++"+driver);
   	 String url = prop.getProperty("db.url");
   	 
      String username = prop.getProperty("db.username");
      String password = prop.getProperty("db.password");
     
       // Class.forName("com.mysql.cj.jdbc.Driver");
        Class.forName(driver);

        return DriverManager.getConnection(
        		url,
        		username,
        		password
        );
    }
    
}