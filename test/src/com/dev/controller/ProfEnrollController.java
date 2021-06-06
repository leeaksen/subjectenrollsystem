package com.dev.controller;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.vo.TestVO;



public class ProfEnrollController<Account> implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int count = Integer.parseInt(request.getParameter("count"));
		String prof = request.getParameter("prof");
		String student = request.getParameter("student");
		
		TestVO test = new TestVO();
		test.setId(id);
		test.setName(name);
		test.setCount(count);
		test.setProf(prof);
		test.setStudent(student);
	
		// service 
		Service s = Service.getInstance();
		s.profenroll(test);
		
		// response
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/result/profenrollResult.jsp");
	}
}
