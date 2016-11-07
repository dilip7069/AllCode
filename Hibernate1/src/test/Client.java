package test;
import beans.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {
	
	public static void main(String[] args)
	{
		Student st=new Student();
		st.setStudentname("testname");
		st.setMarks(100);
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(st);
		tx.commit();
		s.close();
		sf.close();
	}
}