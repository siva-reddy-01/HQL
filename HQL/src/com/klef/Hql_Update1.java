package com.klef;
import org.hibernate.cfg.*;
import org.hibernate.*;
public class Hql_Update1
{
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void main(String args[])
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();//Transient state
		
		//update -1stway
		Query qry1=session.createQuery("update Faculty set name=?0,age=?1 where id=?2");
		qry1.setString(0, "Anitha");
		qry1.setInteger(1, 20);
		qry1.setInteger(2, 1290);
		
		Transaction txt=session.beginTransaction();
		int n1=qry1.executeUpdate();
		System.out.println(n1+"Record(s) are updated");
		
		txt.commit();
		session.close();
		sf.close();
		
		
		
	}

}
