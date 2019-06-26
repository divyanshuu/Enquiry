package com.proptiger.server.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ENQUIRY")
public class Server {
	
	@Id
	private int id;
	@Column(name="CITY_ID")
	private int city_id;
	@Column(name="CITY_NAME")
	private String city_name;
	@Column(name="CREATED_DATE")
	private Date created_date;
	// @Column(name="ENQUIRY_TYPE_ID")
	//private int enquiry_type_id;
	@Column(name="LEAD_SALE_TYPE")
	private String lead_sale_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
	public String getLead_sale_type() {
		return lead_sale_type;
	}
	public void setLead_sale_type(String lead_sale_type) {
		this.lead_sale_type = lead_sale_type;
	}
	
	public Server()
	{
		
	}

}

