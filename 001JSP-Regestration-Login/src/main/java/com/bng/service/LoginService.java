package com.bng.service;

import java.io.IOException;
import com.bng.dao.LoginDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginService {

	public boolean validateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		System.out.println("In  LoginService++++++++ ");						
	LoginDao loginDao=new LoginDao();
	boolean status=loginDao.validateUser(req, resp);
	if (status) {
        resp.sendRedirect("loginSuccess.jsp");
    } 
	else {
        resp.sendRedirect("loginFail.jsp");
    }
	return status;
	}
}
