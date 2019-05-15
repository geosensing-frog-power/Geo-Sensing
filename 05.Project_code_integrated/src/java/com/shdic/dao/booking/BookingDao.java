package com.shdic.dao.booking;

import java.util.ArrayList;

import com.shdic.bean.SlotBean;

public interface BookingDao {
	 ArrayList<SlotBean> listSlots(String parking_id) throws Exception; 
	 
	 
	 ArrayList<SlotBean> bookingSlot(String parking_id,String slot_id, String email) throws Exception; 
}
