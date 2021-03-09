package com.sobis.interfaces;

import java.util.List;


import com.sobis.bean.Ticket;

public interface TicketDaoI {

	boolean add(Ticket customer);
	public List<Ticket> getAllDetail();
    public List<Ticket>  getDetailByEmail(String email);
    public Ticket getDetailById(long custId);
    public boolean updateStatus(long custId,String status);
}
