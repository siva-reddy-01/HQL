package com.klef;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class Retrive4 
{
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String args[])
	{
		
	  Configuration cfg=new Configuration();
	  cfg.configure("hibernate.cfg.xml");
	  SessionFactory sf=cfg.buildSessionFactory();
	  Session session=sf.openSession();//Transient state
	  
	  Query qry4=session.createQuery("from Faculty where id=1290");
	  List<Faculty> list4=qry4.list();
	  System.out.println("Total number of records="+list4.size());
	  for(Faculty faculty:list4)
	  {
		  System.out.println(faculty.getid()+","+faculty.getName()+","+faculty.getDepartment()+","+faculty.getDesignation()+","+faculty.getAge()+","+faculty.getSalary());
		  
	  }
	  session.close();
	  sf.close();
	}

}
