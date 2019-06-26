package com.proptiger.local;

public class Display {

	int time;
	Long count;
	String city;
	String type;
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Display() {
		// TODO Auto-generated constructor stub
	}
	public Display(int time, Long count, String city,String type) {
		super();
		this.time = time;
		this.count = count;
		this.city = city;
		this.type = type;
	}
	
	
}
