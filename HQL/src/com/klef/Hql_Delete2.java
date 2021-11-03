package com.klef;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Hql_Delete2 
{
	@SuppressWarnings({ "unused", "deprecation", "rawtypes" })
	public static void main(String args[])
	{
		Configuration cfg=new Configuration();
		  cfg.configure("hibernate.cfg.xml");
		  SessionFactory sf=cfg.buildSessionFactory();
		  Session session=sf.openSession();//Transient state
		  
		  //delete 2nd way
		  Query qry2=session.createQuery("delete from Faculty where id=:v1");
		  qry2.setParameter("v1",1290);
		  
		  Transaction txt=session.beginTransaction();
		  int n2=qry2.executeUpdate();
		  System.out.println(n2+"Record(S) are deleted");
		  txt.commit();
		  session.close();
		  sf.close();
		  
		  
	}

}
