package com.bng.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bng.config.DbUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegestrationDao {
	
	
	public void saveUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("++++++++ Inside RegestrationDao ++++++++");

		PrintWriter out = resp.getWriter();
		String userName=req.getParameter("userName");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String password=req.getParameter("password");

		 try {
	         // 1. Load Driver
			// Load driver from properties
	            Class.forName(DbUtil.getDriver());

	            // Create connection using properties
	            Connection con = DriverManager.getConnection(
	            		DbUtil.getUrl(),
	            		DbUtil.getUsername(),
	            		DbUtil.getPassword());
	         // 3. Prepare Query
	         String query = "INSERT INTO users(username, email, phone, password) VALUES (?, ?, ?, ?)";
	         PreparedStatement ps = con.prepareStatement(query);

	         // 4. Set Values
	         ps.setString(1, userName);
	         ps.setString(2, email);
	         ps.setString(3, phone);
	         ps.setString(4, password);

			
	      // 5. Execute
	         int result = ps.executeUpdate();

	         if (result > 0) {
	             out.println("User Registered Successfully!");
	         } else {
	             out.println("Registration Failed!");
	         }

	         // 6. Close Resources
	         ps.close();
	         con.close();

	     } catch (Exception e) {
	         e.printStackTrace();
	         out.println("Error: " + e.getMessage());
	     }



	}
}
