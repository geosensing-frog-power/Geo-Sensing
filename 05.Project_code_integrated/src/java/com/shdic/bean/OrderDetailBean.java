package com.shdic.bean;

public class OrderDetailBean implements java.io.Serializable {
	private  String order_id		;
	private  String parking_id	    ;
	private  String slot_id		    ;
	private  String start_time	    ;
	private  String end_time	    ;
	private  String recepit_no	    ;
	private  String order_status    ;
	private  String Amount		    ;
	private  String email           ;
	private  String send_email_status           ;
	
	
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getParking_id() {
		return parking_id;
	}
	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}
	public String getSlot_id() {
		return slot_id;
	}
	public void setSlot_id(String slot_id) {
		this.slot_id = slot_id;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getRecepit_no() {
		return recepit_no;
	}
	public void setRecepit_no(String recepit_no) {
		this.recepit_no = recepit_no;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSend_email_status() {
		return send_email_status;
	}
	public void setSend_email_status(String send_email_status) {
		this.send_email_status = send_email_status;
	}
	
	
}
