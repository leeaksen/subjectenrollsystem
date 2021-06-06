package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FrontController extends HttpServlet{
		HashMap <String, Controller> list = null;
	
		@Override
		public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
			list = new HashMap<String, Controller> ();
			list.put("/login.do", new ProfLoginController());
			list.put("/login.do", new StudentLoginController());
			list.put("/profenroll.do", new ProfEnrollController());
			list.put("/studentenroll.do", new StudentEnrollController());
			list.put("/profenrolllist.do", new ProfEnrollListController());
			list.put("/studentenrolllist.do", new StudentEnrollListController());
			list.put("/profenrollstudent.do", new ProfEnrollStudentController());
		}
			
			@Override
			protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
			String uri = req.getRequestURI();
			String contextPath = req.getContextPath();
			String path = uri.substring(contextPath.length());
			}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				super.doPost(req, resp);
	}
	}
