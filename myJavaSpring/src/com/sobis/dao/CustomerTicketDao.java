package com.sobis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import com.sobis.bean.Ticket;

import com.sobis.interfaces.TicketDaoI;

@Repository
public class CustomerTicketDao implements TicketDaoI {
	//@Qualifier(value="sessionFactory")
	private SessionFactory sessionFactory;

	@Autowired
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean add(Ticket customer) {
		try{
			System.out.println("inside add in dao");
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(customer);
		session.getTransaction().commit();
		return true;
		}
		catch(Exception e){
			return false;
		}
		
	}

	@Override
	public List<Ticket> getAllDetail() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Ticket");
		return query.list();

	}

	@Override
	public List<Ticket> getDetailByEmail(String email) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Ticket where email=?");
		query.setParameter(0 ,email);
		return query.list();
	
	}

	@Override
	public Ticket getDetailById(long custId) {
		return (Ticket) sessionFactory.openSession().get(Ticket.class, custId);
	}

	
public boolean updateStatus(long custId, String status) {
		try{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("update Ticket set status=? where custId=?");
		query.setParameter(0 ,status);
		query.setParameter(1, custId);
		return true;
		}
		catch(Exception e){
			return false;
		}
	}

}
