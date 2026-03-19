package com.bng.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bng.config.DBConnection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class LoginDao {
	public boolean validateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("++++++++ Inside RegestrationDao ++++++++");
		PrintWriter out = resp.getWriter();
		String userName1=req.getParameter("userName");
		String password1=req.getParameter("password");
		 boolean status = false;

	        try {
	            Connection con = DBConnection.getConnection();

	            PreparedStatement ps = con.prepareStatement(
	                "SELECT * FROM users WHERE username=? AND password=?"
	            );

	            ps.setString(1, userName1);
	            ps.setString(2, password1);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                status = true;
	            }
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return status;
}
	
}
