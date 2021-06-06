package com.dev.controller;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudentLoginController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String student = request.getParameter("student");
		
		Service s = Service.getInstance();
		boolean resultS = s.studentlogin(id, pwd, student);
		String path = null;
		String on = request.getParameter("on");
		if (on.equals("student"))
			path = "/test0601/studentmenu.jsp";
		else
		{
			path = "/index.jsp";
		}
		HttpUtil.forward(request, response, path);
	}

}
