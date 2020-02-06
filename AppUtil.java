package com.scp.java.endtoend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppUtil {
	
	private AppUtil() {
	}

	static private SessionFactory sfactory = null;

	public static SessionFactory getSessionFactory() {//1 -- singleToneApproach
		if(sfactory==null) {
			sfactory = new Configuration().configure("mysql-hibernate.cfg.xml").buildSessionFactory();
		}
		return sfactory;
	}
	
	public static void cleanUpResources(Session session,Transaction tr) {
		if(session!=null) {
			if(tr!=null) {
					session.flush();
					tr.commit();
			}
			session.close();
		}
	}
}
