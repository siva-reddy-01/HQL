package com.klef;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class Hql_Update3 
{
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void main(String args[])
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();//Transient state
		
		//update 3rd-way
		Query qry3=session.createQuery("update Faculty set name='Anitha' where id=1290");
		Transaction txt=session.beginTransaction();
		int n3=qry3.executeUpdate();
		System.out.println(n3+"Record(s) are updated");
		txt.commit();
		session.close();
		sf.close();
		
		
		
		
	}

}
