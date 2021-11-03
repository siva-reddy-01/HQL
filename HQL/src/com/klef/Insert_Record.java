package com.klef;
import org.hibernate.cfg.*;
import org.hibernate.*;
public class Insert_Record
{
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Faculty faculty=new Faculty();
		faculty.setid(1290);
		faculty.setName("siva");
		faculty.setDepartment("CSE");
		faculty.setDesignation("IT");
		faculty.setAge(25);
		faculty.setSalary(120.2);
		
		Transaction txt=session.beginTransaction();
		session.save(faculty);
		txt.commit();
		
		System.out.println("Records are inserted..");
		
		session.close();
		sf.close();
		
	}

}
