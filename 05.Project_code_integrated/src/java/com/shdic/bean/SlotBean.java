package com.shdic.bean;

public class SlotBean implements java.io.Serializable{
	private String parking_id;
	private String slot_id;
	private String parking_station;
	private String status;
	private String price ;
	private String charging_from;
	private String charging_to;
	private String location_lat;  //'08:00'
	private String location_lng;  //'16:00'
	

	
	public SlotBean(String parking_id,String slot_id,String status,String price ,String charging_from,String charging_to){
		this.parking_id = parking_id;
		this.slot_id = slot_id;
		//this.parking_station = parking_station;
		this.status = status ;
		this.price = price;
		this.charging_from = charging_from;
		this.charging_to = charging_to;
		//this.location_lat = location_lat;
		//this.location_lng = location_lng;
	}
	public SlotBean(){}
	
	//get value
	public String getParking_id(){
		return parking_id;
	}
	
	public String getSlot_id(){
		return slot_id;
	}
	
	public String getParking_station(){
		return parking_station;
	}
	public String getStatus(){
		return status;
	}

	// set value
	public void setParking_id(String input){
		parking_id = input;
	}
	
	public void setSlot_id(String input){
		slot_id = input;
	}
	
	public void setParking_station(String input){
		parking_station = input;
	}
	public void setStatus(String input){
		status = input;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCharging_from() {
		return charging_from;
	}
	public void setCharging_from(String charging_from) {
		this.charging_from = charging_from;
	}
	public String getCharging_to() {
		return charging_to;
	}
	public void setCharging_to(String charging_to) {
		this.charging_to = charging_to;
	}
	public String getLocation_lat() {
		return location_lat;
	}
	public void setLocation_lat(String location_lat) {
		this.location_lat = location_lat;
	}
	public String getLocation_lng() {
		return location_lng;
	}
	public void setLocation_lng(String location_lng) {
		this.location_lng = location_lng;
	}
}
