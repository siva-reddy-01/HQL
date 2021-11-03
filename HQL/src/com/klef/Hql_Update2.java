package com.klef;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class Hql_Update2 
{
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void main(String args[])
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();//Transient state
		
		//update 2nd-way
		Query qry2=session.createQuery("update Faculty set name=:v1 where id=:v2");
		qry2.setParameter("v1","Liki");
		qry2.setParameter("v2", 1290);
		
		Transaction txt=session.beginTransaction();
		int n2=qry2.executeUpdate();
		System.out.println(n2+"Record(s) are updated");
		txt.commit();
		session.close();
		sf.close();
		
	}

}
