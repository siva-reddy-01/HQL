package com.klef;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class Hql_Delete1 
{

	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void main(String[] args)
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

}
