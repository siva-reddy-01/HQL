package com.klef;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
@SuppressWarnings("deprecation")
public class skill7
{
	@SuppressWarnings({ })
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		boolean exit=false;
		while(!exit)
		{
			System.out.println("1.Display all the employee details in the organization");
			System.out.println("2.Display only names of all employees whose age is greater than 40");
			System.out.println("3.Delete an employee whose Empid is 1290");
			System.out.println("4.Update the name of the employee with ******whose Empid is ?");
			System.out.println("5.Insert employee details");
			System.out.println("6.exit the prograam");
			
			int choice=sc.nextInt();
			switch(choice)
			{
			 case 1:
				 Display_Employee_Details();
				 break;
			 case 2:
				 Display_Employee_Details_Age();
				 break;
			 case 3:
				 Delete_Employee_Details();
				 break;
			 case 4:
				 Update_Employee_Details();
				 break;
			 case 5:
				 Insert_Details();
			 default:
				 System.out.println("please try again");
				 break;
				 
			}
		}
		sc.close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void Display_Employee_Details() 
	{
		  Configuration cfg=new Configuration();
		  cfg.configure("hibernate.cfg.xml");
		  SessionFactory sf=cfg.buildSessionFactory();
		  Session session=sf.openSession();
		  
		  Query qry1=session.createQuery("from Faculty");
		  List<Faculty> list1=qry1.list();
		  for(Faculty faculty : list1)
		  {
			  System.out.println(faculty.getid()+","+faculty.getName()+","+faculty.getDepartment()+","+faculty.getDesignation()+","+faculty.getAge()+","+faculty.getSalary());
		  }
		  session.close();
		  sf.close();
	}
	
	@SuppressWarnings("rawtypes")
	public static void Display_Employee_Details_Age()
	{
		
	  Configuration cfg=new Configuration();
	  cfg.configure("hibernate.cfg.xml");
	  SessionFactory sf=cfg.buildSessionFactory();
	  Session session=sf.openSession();//Transient state
	  
	  Query qry4=session.createQuery("from Faculty where id=1290");
	  @SuppressWarnings("unchecked")
	List<Faculty> list4=qry4.list();
	  System.out.println("Total number of records="+list4.size());
	  for(Faculty faculty:list4)
	  {
		  System.out.println(faculty.getid()+","+faculty.getName()+","+faculty.getDepartment()+","+faculty.getDesignation()+","+faculty.getAge()+","+faculty.getSalary());
		  
	  }
	  session.close();
	  sf.close();
	}
	@SuppressWarnings("rawtypes")
	public static void Delete_Employee_Details()
	{
	  Configuration cfg=new Configuration();
	  cfg.configure("hibernate.cfg.xml");
	  SessionFactory sf=cfg.buildSessionFactory();
	  Session session=sf.openSession();//Transient state
	  
	  //delete 1st way
	  Query qry1=session.createQuery("delete from Faculty where id=?0");
	  qry1.setInteger(0,1290);
	  
	  Transaction txt=session.beginTransaction();
	  int n1=qry1.executeUpdate();
	  System.out.println(n1+"Record(s) are deleted");
	  txt.commit();
	  session.close();
	  sf.close();	
	}
	
	@SuppressWarnings({ "rawtypes", "resource" })
	public static void Update_Employee_Details()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter empoyee id");
		int id=sc.nextInt();
		System.out.println("enter employee name");
		String name=sc.next();
		System.out.println("enter employee age");
		int age=sc.nextInt();
		Query qry1=session.createQuery("update Faculty set name=?0,age=?1 where id=?2");
		qry1.setString(0, name);
		qry1.setInteger(1, age);
		qry1.setInteger(2, id);
		
		Transaction txt=session.beginTransaction();
		int n1=qry1.executeUpdate();
		System.out.println(n1+"Record(s) are updated");
		
		txt.commit();
		session.close();
		sf.close();
	}
	
	@SuppressWarnings({ "unused", "resource" })
	public static void Insert_Details()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee id");
		int id=sc.nextInt();
		System.out.println("enter employee name");
		String name=sc.next();
		System.out.println("enter employee department");
		String department=sc.next();
		System.out.println("enter employee designation");
		String designation=sc.next();
		System.out.println("enter employee age");
		int age=sc.nextInt();
		System.out.println("enter employee salary");
		double salary=sc.nextDouble();
		Faculty faculty=new Faculty();
		faculty.setid(id);
		faculty.setName(name);
		faculty.setDepartment(department);
		faculty.setDesignation(designation);
		faculty.setAge(age);
		faculty.setSalary(salary);
		Transaction txt=session.beginTransaction();
		session.save(faculty);
		txt.commit();
		System.out.println("Records are inserted..");
		session.close();
		sf.close();
	}
}
