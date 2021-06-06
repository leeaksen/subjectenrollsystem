package com.dev.controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.vo.TestVO;

public class ProfEnrollListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service s = Service.getInstance();
		ArrayList<TestVO> list = service.ProfenrollList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/profenrollListResult.jsp");
	}

}
