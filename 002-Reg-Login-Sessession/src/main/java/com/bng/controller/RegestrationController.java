package com.bng.controller;

import java.io.IOException;
import com.bng.dao.RegestrationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/regestration")
public class RegestrationController extends HttpServlet {
	RegestrationDao  segestrationDao=new RegestrationDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("++++++++ Inside RegestrationController ++++++++");
		
		segestrationDao.saveUser(req, resp);
           }
}