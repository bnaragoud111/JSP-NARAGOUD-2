package com.bng.controller;

import java.io.IOException;

import com.bng.service.LoginService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	LoginService loginServce=new LoginService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("Inside Logout Controller ");
		HttpSession session = req.getSession(false);

		if (session != null) {
		    session.invalidate();  // 🔥 destroy session
		}

		resp.sendRedirect("login.html");
	  //  resp.sendRedirect(req.getContextPath() + "/login.html");

		System.out.println("Logout Success...... !");
		
           }

}

