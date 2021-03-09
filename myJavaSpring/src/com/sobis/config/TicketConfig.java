package com.sobis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sobis.bean.Ticket;
import com.sobis.dao.CustomerTicketDao;
import com.sobis.service.TicketService;

@Configuration
public class TicketConfig {
	@Bean
	public Ticket getTicket() {
		return new Ticket();
	}
@Bean
public CustomerTicketDao getDao() {
	return new CustomerTicketDao();
}
	@Bean
	public TicketService getService() {
		return new TicketService();
}

}
