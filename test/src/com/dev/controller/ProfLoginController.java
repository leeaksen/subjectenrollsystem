package com.dev.controller;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfLoginController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String professor = request.getParameter("professor");
			
			Service s = Service.getInstance();
			boolean result = s.professorlogin(id, pwd, professor);
			String path = null;
			String on = request.getParameter("on");
			if (on.equals("professor"))
				path = "/test0601/professormenu.jsp";
			else
			{
				path = "/index.jsp";
			}
			HttpUtil.forward(request, response, path);
	}

}
