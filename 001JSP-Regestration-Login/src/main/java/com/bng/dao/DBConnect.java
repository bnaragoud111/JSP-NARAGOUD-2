package com.bng.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBConnect {

    public static Connection getConn()
    {
        ResourceBundle rd
            = ResourceBundle.getBundle("config");
        Connection con = null;

        // driver name for mysql
        String loadDriver = rd.getString("driver");

        // url of the database
        String dbURL = rd.getString("url");

        // username to connect db
        String dbUSERNAME = rd.getString("userName");

        // password to connect db
        String dbPASSWORD = rd.getString("password");

        try {
            // load the driver
            Class.forName(loadDriver);

            // get the connection
            con = DriverManager.getConnection(
                dbURL, dbUSERNAME, dbPASSWORD);
            Statement st = con.createStatement();
            ResultSet rs
                = st.executeQuery("SELECT * FROM CUSTOMER");
            while (rs.next()) {
                System.out.println(
                    "ID -" + rs.getInt(1) + " || "
                    + "First-Name -" + rs.getString(2)
                    + " || "
                    + "LastName -" + rs.getString(4));
            }
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return con;
    }
   }