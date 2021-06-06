package com.dev.vo;

public class TestVO {
	private String id;
	private String pwd;
	private String name;
	private String student;
	private String prof;
	private int count;
	public TestVO() {}
	public TestVO(String tId, String tPwd, String tName, String tProf, String tStudent)
	{
		this.id = tId;
		this.pwd = tPwd;
		this.name = tName;
		this.count = 50;
		this.prof = tProf;
		this.student = tStudent;
		
	}
	public String getId()
	{
		return id;
	}
	public void setId(String tId)
	{
		this.id = tId;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String tPwd)
	{
		this.pwd = tPwd;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String tName)
	{
		this.name = tName;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int tCount)
	{
		this.count = tCount;
	}
	public String getProf()
	{
		return prof;
	}
	public void setProf(String tProf)
	{
		this.prof = tProf;
	}
	public String getStudnet()
	{
		return student;
	}
	public void setStudent(String tStudent)
	{
		this.student = tStudent;
	}
}
