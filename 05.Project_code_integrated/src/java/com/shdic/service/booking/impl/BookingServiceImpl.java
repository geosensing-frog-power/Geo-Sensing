package com.shdic.service.booking.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shdic.bean.SlotBean;
import com.shdic.dao.booking.BookingDao;
import com.shdic.dao.login.LoginDao;
import com.shdic.service.booking.BookingService;
import com.shdic.service.login.impl.LoginServiceImpl;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

	@Resource(name="bookingDao")
	private BookingDao bookingDao;
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Override
	public ArrayList<SlotBean> listSlots(String parking_id) throws Exception {
		// TODO Auto-generated method stub
		return bookingDao.listSlots(parking_id);
	}

	@Override
	public ArrayList<SlotBean> bookingSlot(String parking_id,String slot_id,String email) throws Exception {
		//Step 1 : Change  slot status from 'Available' => 'Unavailable' , 
		//return ArrayList with SlotBean.status = 'Unavailable' 
		
		//Step 2 : Booking slot , create booking order
				    
		//Step 3 : Send email with receipt 
		return bookingDao.bookingSlot(parking_id,slot_id,email);
	}
}
