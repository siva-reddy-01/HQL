package com.klef;
import java.util.List;
import org.hibernate.cfg.*;
import org.hibernate.*;
public class Retrive1 
{

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String[] args) 
	{
		  Configuration cfg=new Configuration();
		  cfg.configure("hibernate.cfg.xml");
		  SessionFactory sf=cfg.buildSessionFactory();
		  Session session=sf.openSession();//Transient state
		  
		  Query qry1=session.createQuery("from Faculty");//Faculty-class name
		  List<Faculty> list1=qry1.list();
		  System.out.println("Total number of records="+list1.size());
		  for(Faculty faculty : list1)//for each loop
		  {
			  System.out.println(faculty.getid()+","+faculty.getName()+","+faculty.getDepartment()+","+faculty.getDesignation()+","+faculty.getAge()+","+faculty.getSalary());
		  }
		  session.close();
		  sf.close();
	}

}
