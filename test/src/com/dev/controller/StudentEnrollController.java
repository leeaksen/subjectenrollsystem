package com.dev.controller;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.vo.TestVO;



public class StudentEnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		
		TestVO test = new TestVO();
		test.setName(name);
		test.setId(id);
	
		// service 
		Service s = Service.getInstance();
		s.studenternoll(test);
		
		// response
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/result/studentenrollResult.jsp");
	}

	}

