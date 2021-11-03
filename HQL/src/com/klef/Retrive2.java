package com.klef;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class Retrive2 
{
	@SuppressWarnings({ "deprecation", "unchecked", "unused", "rawtypes" })
	public static void main(String[] args) 
	{
		  Configuration cfg=new Configuration();
		  cfg.configure("hibernate.cfg.xml");
		  SessionFactory sf=cfg.buildSessionFactory();
		  Session session=sf.openSession();//Transient state
		  
		  Query qry2=session.createQuery("from Faculty where id=:v1");
		  qry2.setParameter("v1", 1290);
		  List<Faculty> list2=qry2.list();
		  System.out.println("Total Number of records="+list2.size());
		  for(Faculty faculty :list2)
		  {
			  System.out.println(faculty.getid()+","+faculty.getName()+","+faculty.getDepartment()+","+faculty.getDesignation()+","+faculty.getAge()+","+faculty.getSalary());
		  }
		  
		  session.close();
		  sf.close();  
	}

}
