package com.klef;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class Hql_Aggregate_functions 
{
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void main(String[] args)
	{
	  Configuration cfg=new Configuration();
	  cfg.configure("hibernate.cfg.xml");
	  SessionFactory sf=cfg.buildSessionFactory();
	  Session session=sf.openSession();//Transient state
	  
	  Query qry1=session.createQuery("select count(*) from Faculty");
	  List list1=qry1.list();
	  System.out.println(list1.get(0));//only one value in the list-index will be stared from 0
	  
	  Query qry2=session.createQuery("select max(salary) from Faculty");
	  List list2=qry2.list();
	  System.out.println(list2.get(0));//only one value in the list-index will be stared from 0
	  
	  Query qry3=session.createQuery("select min(salary) from Faculty");
	  List list3=qry3.list();
	  System.out.println(list3.get(0));//only one value in the list-index will be stared from 0
	  
	  Query qry4=session.createQuery("select sum(salary) from Faculty");
	  List list4=qry4.list();
	  System.out.println(list4.get(0));//only one value in the list-index will be stared from 0
	  
	  Query qry5=session.createQuery("select avg(salary) from Faculty");
	  List list5=qry5.list();
	  System.out.println(list5.get(0));//only one value in the list-index will be stared from 0
	}
}
