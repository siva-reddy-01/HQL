package com.klef;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Retrive3 
{
	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static void main(String args[])
	{
		
	  Configuration cfg=new Configuration();
	  cfg.configure("hibernate.cfg.xml");
	  SessionFactory sf=cfg.buildSessionFactory();
	  Session session=sf.openSession();//Transient state
	  
	  Query qry3=session.createQuery("from Faculty where id=?0");
	  qry3.setInteger(0, 1290);
	  List<Faculty> list3=qry3.list();
	  System.out.println("Total number of records="+list3.size());
	  for(Faculty faculty:list3)//for each loop
	  {
		  System.out.println(faculty.getid()+","+faculty.getName()+","+faculty.getDepartment()+","+faculty.getDesignation()+","+faculty.getAge()+","+faculty.getSalary()); 
		  
	  }
	  session.close();
	  sf.close();
	  
	  
	  
	  
	}

}
