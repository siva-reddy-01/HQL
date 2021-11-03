package com.klef;

public class Faculty 
{
	private int id;
	private String name;
	private String department;
	private String designation;
	private int age;
	private double salary;
	
	public void setid(int id)
	{
		this.id=id;
	}
	
	public int getid()
	{
		return id;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getDepartment() 
	{
		return department;
	}

	public void setDepartment(String department) 
	{
		this.department = department;
	}

	public String getDesignation() 
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public double getSalary() 
	{
		return salary;
	}

	public void setSalary(double salary) 
	{
		this.salary = salary;
	}
}
