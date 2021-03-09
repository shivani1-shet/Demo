package com.sobis.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity
@Table(name="ticket")
@Component
public class Ticket {
	/*@Value(value="1001")*/
	@Id
	@Column
	private long custId;
	
	private String name;
	private String email;
	private String complain;
	
	
	private String status="open";
	
	public String toString(){
		return "Ticket [isbn=" + name + ", title=" + email +" ,"+ complain+"]" ;
	}

	public Ticket() {
		super();
	}


//	public Ticket(String name, String email, String complain) {
//		super();
//		this.name = name;
//		this.email = email;
//		this.complain = complain;
//			}


	public long getCustId() {
		return custId;
	}


	public void setCustId(long custId) {
		this.custId = custId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getComplain() {
		return complain;
	}


	public void setComplain(String complain) {
		this.complain = complain;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
	
	
	
	
}
