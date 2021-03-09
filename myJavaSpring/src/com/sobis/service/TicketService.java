package com.sobis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sobis.bean.Ticket;

import com.sobis.interfaces.TicketDaoI;
import com.sobis.interfaces.TicketServiceI;

@Service

public class TicketService implements TicketServiceI {
	
	@Autowired
	private TicketDaoI ticketDao;

	public TicketDaoI getCustomerTicketDao() {
		return ticketDao;
	}

	public void setCustomerTicketDao(TicketDaoI customerTicketDao) {
		this.ticketDao = customerTicketDao;
	}

	@Override
	public boolean add(Ticket customer) {
		return ticketDao.add(customer);
		
	}

	@Override
	public List<Ticket> getAllDetail() {
		
		return ticketDao.getAllDetail();
	}

	@Override
	public List<Ticket> getDetailByEmail(String email) {
		
		return ticketDao.getDetailByEmail(email);
	}

	@Override
	public Ticket getDetailById(long custId) {
		
		return ticketDao.getDetailById(custId);
	}

	@Override
	public boolean updateStatus(long custId, String status) {
	
		return ticketDao.updateStatus(custId, status);
	}
	

}
