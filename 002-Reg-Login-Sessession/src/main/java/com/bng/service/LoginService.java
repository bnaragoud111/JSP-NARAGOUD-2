package com.bng.service;

import java.io.IOException;
import com.bng.dao.LoginDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginService {

	public boolean validateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("In  LoginService++++++++ ");
		String username = req.getParameter("userName");
		//Session creation
		HttpSession session = req.getSession();
		session.setAttribute("user", username);
		
		LoginDao loginDao = new LoginDao();
		boolean status = loginDao.validateUser(req, resp);
		if (status) {
			resp.sendRedirect("loginSuccess.jsp");
		} else {
			resp.sendRedirect("loginFail.jsp");
		}
		return status;
	}
}
