package com.sobis.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sobis.bean.Ticket;
import com.sobis.config.TicketConfig;
import com.sobis.dao.CustomerTicketDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.sobis.interfaces.TicketServiceI;
import com.sobis.service.TicketService;


@Controller

public class TicketController {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=null;
		try {
			context=new AnnotationConfigApplicationContext(TicketConfig.class);
			context=new AnnotationConfigApplicationContext(CustomerTicketDao.class);
			context=new AnnotationConfigApplicationContext(TicketService.class);

			Ticket ticket=context.getBean("getTicket", Ticket.class);
			System.out.println(ticket);
			CustomerTicketDao Dao=context.getBean("getDao", CustomerTicketDao.class);
			System.out.println("dao"+Dao);
			TicketService service=context.getBean("getService", TicketService.class);
			System.out.println("service"+service);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			if(context!=null)
				context.close();
		}
	}
	
		private TicketServiceI customerTicketservice; ;

		public TicketServiceI getCustomerTicketservice() {
			return customerTicketservice;
		}
		public void setCustomerTicketservice(TicketServiceI customerTicketservice) {
			this.customerTicketservice = customerTicketservice;
		}
		
		@ResponseBody
		@RequestMapping("/hello") 
		public String sayHello()
		{
			return "Hello World!"; 
		}
		
		@RequestMapping("/start")
		public String showLoginForm(Model model){
		System.out.println("inside start");
		model.addAttribute("cust", new Ticket());
		System.out.println("leaving start");
			return "login";
		}
		
		@RequestMapping("/submit")
		public String add(@ModelAttribute("cust")Ticket cust,Model model){
			System.out.println("inside submit(add)"+cust.getName()+" "+cust.getEmail());
			if(customerTicketservice.add(cust)){
				System.out.println("loggedIn");
				List<Ticket> ticket=customerTicketservice.getDetailByEmail(cust.getEmail());
				model.addAttribute("ticket",ticket);
				System.out.println("detail:"+ticket);
				return "detail";
			}
			
			return "login";
		}
		
		@RequestMapping("/view")
		public String detail(){	
			return "view";
		}
		
		
		@RequestMapping("/admin")
		public String detail2(){	
			return "admin";
		}
		
		
		/*@RequestMapping("/adminLogin")
		public String detail1(@RequestParam("email")String email,@RequestParam("password") String password,Model model){	
			if(email.equals("admin")&& password.equals("admin"))
			{
				System.out.println("Admin");
				List<Ticket> ticketList=customerTicketservice.getAllDetail();
				model.addAttribute("ticket",ticketList);
				System.out.println(ticketList);
			return "adminDetail";
			}
			else
				return "submit";
		}*/

		@RequestMapping("/adminLogin")
		public String detail1(@RequestParam("email")String email,@RequestParam("password") String password,Model model){	
			if(email.equals("admin")&& password.equals("admin"))
			{
				System.out.println("Admin");
				
			return "redirect:/getDetail";
			}
			else
				return "submit";
		}
		@RequestMapping("/getComplaint")
		public String getComplain(@RequestParam("email") String email,Model model){
			
			System.out.println("email"+email);
			List<Ticket> ticket=customerTicketservice.getDetailByEmail(email);
			model.addAttribute("ticket",ticket);
			System.out.println("detail:"+ticket);
			return "detail";
			
		}
		
		@RequestMapping("/getDetail")
		public String  getAllDetails(Model model){
			System.out.println("inside getDetail");
			List<Ticket> ticketList=customerTicketservice.getAllDetail();
			model.addAttribute("ticket",ticketList);
			System.out.println(ticketList);
			return "adminDetail";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		/*@RequestMapping("/update")
		public String update(@RequestParam("custId") String custId,Model model){
			long custId1=Long.parseLong(custId);
			System.out.println("custId: "+custId1);
		Ticket ticket=customerTicketservice.getDetailById(custId1);
			model.addAttribute("ticket",ticket);
			System.out.println("detail:"+ticket);
			return "update";
		}
		@RequestMapping("/updateStatus")
		public String updateStatus(@RequestParam("custId") String custId,@RequestParam("status") String status){
			System.out.println();
			long custId2=Long.parseLong(custId);
			boolean a= customerTicketservice.updateStatus(custId2, status);
			System.out.println(a);
			return "redirect:/getDetail";
		}*/
		
		
	}


