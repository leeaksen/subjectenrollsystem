package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.dev.vo.TestVO;


public class TestDAO {
	private static TestDAO dao = new TestDAO();
	private TestDAO() {}
	public static TestDAO getInstance() {
		return dao;
	}
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classes", "root" , "1127");
		}catch(Exception e)
		{
			System.out.print("MDAO : connect"+e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.print("Pstmt close error" +e);
			}
		}
		if(conn != null)
		{
			try {
				conn.close();
			}catch(Exception e)
			{
				System.out.print("Conn close error" +e);
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if (rs != null)
		{
			try { 
				rs.close();
			}catch (Exception e)
			{
				System.out.print("rs close error" +e);
			}
		}
		close(conn, pstmt);
	}
	public boolean studentlogin(String id, String pwd, String student) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from student where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(5, student);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
			}
			else
				result = false;
		}catch(Exception e)
		{
			System.out.print("student login error" +e);
		}
		finally
		{
			close(conn, pstmt, rs);
		}
		return result;
	}
	public boolean professorlogin(String id, String pwd, String prof) {
	
	boolean result = false;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		conn = connect();
		pstmt = conn.prepareStatement("select * from prof where id = ? and pwd = ?;");
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(4, prof);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			result = true;
		}
		else
			result = false;
	}catch(Exception e)
	{
		System.out.print("proflogin error" +e);
	}
	finally
	{
		close(conn, pstmt, rs);
	}
	return result;
}
	public void profenroll(TestVO test)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?, ?, ?, ?);");
			pstmt.setString(1, test.getId());
			pstmt.setString(2, test.getName());
			pstmt.setString(3, test.getCount()+"");
			pstmt.setString(4, test.getProf());
			pstmt.executeUpdate();
			
		}catch(Exception e)
		{
			System.out.print("profenroll error" +e);
		}
		finally
		{
			close(conn, pstmt);
		}
	}
	public ArrayList<TestVO> profenrollList() {
			// TODO Auto-generated method stub
			ArrayList<TestVO> list = new ArrayList<TestVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			TestVO test = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from subject");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					test = new TestVO();
					test.setId(rs.getString(1));
					test.setName(rs.getString(2));
					pstmt.setString(3, test.getCount()+"");
					list.add(test);
				}
			} catch (Exception e) {
				System.out.print("profenrollList error : " +e);
			} finally {
				close(conn, pstmt, rs);
			}
			return list;
			}
	public ArrayList<TestVO> studentenrollList() {
		// TODO Auto-generated method stub
		ArrayList<TestVO> list = new ArrayList<TestVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		TestVO test = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from subject where id = ?;");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				test = new TestVO();
				test.setId(rs.getString(1));
				test.setName(rs.getString(2));
				list.add(test);
			}
		} catch (Exception e) {
			System.out.print("studentenrollList error : " +e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
		}
	public void studentenroll(TestVO test)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from enroll where name=?;");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				test = new TestVO();				
				test.setName(rs.getString(3));
				test.setId(rs.getString(1));
			}
		}catch(Exception e)
		{
			System.out.print("studentenroll error" +e);
		}finally { 
			close (conn, pstmt, rs);
		}
	}
	public ArrayList<TestVO> profenrollstudent() {
		// TODO Auto-generated method stub
		ArrayList<TestVO> list = new ArrayList<TestVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		TestVO test = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from enroll");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				test = new TestVO();
				test.setId(rs.getString(1));
				test.setStudent(rs.getString(5));
				list.add(test);
			}
		} catch (Exception e) {
			System.out.print("profenrollstudent error : " +e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
		}
	
}
