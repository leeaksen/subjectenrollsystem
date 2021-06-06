package com.dev.service;

import java.util.ArrayList;

import com.dev.dao.TestDAO;
import com.dev.vo.TestVO;

public class TestService {
	private static TestService service = new TestService();
	private TestService() {}
	private TestDAO dao = TestDAO.getInstance();
	public static TestService getInstance()
	{
		return service;
	}
	
	public boolean studentlogin (String id, String pwd, String student)
	{
		return dao.studentlogin(id, pwd, student);
	}
	public boolean professorlogin (String id, String pwd, String prof)
	{
		return dao.professorlogin(id, pwd, prof);
	}
	public void profenroll (TestVO test)
	{
		dao.profenroll(test);
	}
	public ArrayList<TestVO> profenrollList()
	{
		ArrayList<TestVO> list = dao.profenrollList();
		return list;
	}
	public ArrayList<TestVO> profenrollstudent()
	{
		ArrayList<TestVO> list = dao.profenrollstudent();
		return list;
	}
	public void studentenroll (TestVO test)
	{
		dao.studentenroll(test);
	}
	public ArrayList<TestVO> studentenrollList()
	{
		ArrayList<TestVO> list = dao.studentenrollList();
		return list;
	}
}
