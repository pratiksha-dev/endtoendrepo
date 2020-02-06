package com.scp.java.endtoend;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.scp.java.endtoend.AppConstants.BookProperties;

public class BookDaoImpl implements BookDao {
	public SessionFactory sfactory =null;
	public BookDaoImpl() {
		sfactory = AppUtil.getSessionFactory();//ini
	}
	
	public int insertBook(BookEn book) {
		Session session =null;
		Transaction tr =null;
		try {
			session  = sfactory.openSession();
			tr = session.beginTransaction();
			return (Integer) session.save(book);
		}catch(Exception e) {
			return 0;
		}finally {
			AppUtil.cleanUpResources(session,tr);			
		}
	}

	public BookEn fetchBook(int bookId) {
		Session session =null;
		try {
			session  = sfactory.openSession();
			return session.get(BookEn.class, bookId);
		}catch(Exception e) {
			return null;
		}finally {
			AppUtil.cleanUpResources(session,null);			
		}
		
	}

	public List<BookEn> fetchAllBook(boolean isDesc,BookProperties ...property) {
		Session session =null;
		try {
			session  = sfactory.openSession();
			//select * from Book_Info
			Criteria cr = session.createCriteria(BookEn.class);
	
			if(property!=null && property.length>0) {
					if(isDesc)
						cr.addOrder(Order.desc(property[0].toString()));
					else
						cr.addOrder(Order.asc(property[0].toString()));
			}else if(isDesc) {
					cr.addOrder(Order.desc("bookId"));
			}
			return cr.list();
			
		}catch(Exception e) {
			return null;
		}finally {
			AppUtil.cleanUpResources(session,null);			
		}
		
	}

	public BookEn modifyBook(BookEn book) {
		Session session =null;
		Transaction tr =null;
		try {
			session  = sfactory.openSession();
			tr = session.beginTransaction();
			session.update(book);
			return book;
		}catch(Exception e) {
			return null;
		}finally {
			AppUtil.cleanUpResources(session,tr);			
		}
	}

	public boolean removeBook(BookEn book) {
		Session session =null;
		Transaction tr =null;
		try {
			session  = sfactory.openSession();
			tr = session.beginTransaction();
			session.delete(book);
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			AppUtil.cleanUpResources(session,tr);			
		}
	
	}

}
