package com.shdic.web.action.booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.shdic.bean.SlotBean;
import com.shdic.service.login.LoginService;
import com.shdic.web.action.BaseAction;
import com.shdic.web.action.login.LoginAction;


@SuppressWarnings("unchecked")
@ParentPackage("struts-default")
@Namespace("/")
@Action(value="bookingAction")
public class BookingAction extends BaseAction {
	//@Resource(name="loginService")
	//private LoginService loginService;
	
	String name = null;
	Logger logger = LoggerFactory.getLogger(LoginAction.class);
	String retStr = "";
	Map conditions = new HashMap();
	
	public String listSlots() throws IOException, ServletException{
	    try{
			
			String parking_id = request.getParameter("parking_id")==null?"x":request.getParameter("parking_id");
			String slot_id = request.getParameter("slot_id")==null?"x":request.getParameter("slot_id");
			String email = request.getParameter("email")==null?"x":request.getParameter("email");
//			conditions.put("email", email);
//			conditions.put("password", password);
			//retStr = loginService.insertName(conditions);
			//retStr = loginService.insertUser(conditions);
			System.out.println("booking listSlot=> "+parking_id+"|"+slot_id+"|"+email);
			System.out.println("retStr=> "+retStr);
			
			SlotBean slot1 =new SlotBean("A","01","Available","2","08:00","06:00");
			SlotBean slot2 =new SlotBean("A","02","Available","2","08:00","06:00");
			
			//ArrayList<SlotBean> slots = 
			
			ArrayList<SlotBean> slots = new ArrayList<SlotBean>();
			slots.add(slot1);
			slots.add(slot2);
			//country=FetchData.getAllCountries();
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(slots, 
					new TypeToken<List<SlotBean>>(){} .getType());
			
			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
			
	    }catch(Exception e){
	    	retStr = "Login failed,Please try it again!";	
			e.printStackTrace();
		}finally{
			//pw(new StringBuffer(retStr));
			/* 
			if (retStr.equals("success")){
				//direct to booking page ,login is seccussful			
				//ServletActionContext.getResponse().sendRedirect("test_direct.jsp");
				System.out.println("login successful!start dispatch!booking=> "+retStr.equals("success"));
				session.put("listview", conditions);
				RequestDispatcher reqDispatcher  = request.getRequestDispatcher("/booking.jsp");
				System.out.println("login successful!finish dispatch!booking=> ");
				reqDispatcher.forward(request,response);
				System.out.println("dispatched!");
			}else{
				System.out.println("retStr <> success");
				session.put("retStr", retStr);
				ServletActionContext.getResponse().sendRedirect("login.jsp");
			}
			**/
				
		}
		return null;

	}
	
	
	
	
	public String updateAjax() throws IOException, ServletException{
	    try{
			
			String parking_id = request.getParameter("parking_id")==null?"x":request.getParameter("parking_id");
			String slot_id = request.getParameter("slot_id")==null?"x":request.getParameter("slot_id");
			String email = request.getParameter("email")==null?"x":request.getParameter("email");
//			conditions.put("email", email);
//			conditions.put("password", password);
			//retStr = loginService.insertName(conditions);
			//retStr = loginService.insertUser(conditions);
			System.out.println("booking controler=> "+parking_id+"|"+slot_id+"|"+email);
			System.out.println("retStr=> "+retStr);
			
			SlotBean slot1 =new SlotBean("A","01","Booked","2","08:00","06:00");
			SlotBean slot2 =new SlotBean("A","02","Available","2","08:00","06:00");
			
			ArrayList<SlotBean> slots=new ArrayList<SlotBean>();
			slots.add(slot1);
			//slots.add(slot2);
			//country=FetchData.getAllCountries();
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(slots, 
					new TypeToken<List<SlotBean>>(){} .getType());
			
			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
			
	    }catch(Exception e){
	    	retStr = "Login failed,Please try it again!";	
			e.printStackTrace();
		}finally{
			//pw(new StringBuffer(retStr));
			/* 
			if (retStr.equals("success")){
				//direct to booking page ,login is seccussful			
				//ServletActionContext.getResponse().sendRedirect("test_direct.jsp");
				System.out.println("login successful!start dispatch!booking=> "+retStr.equals("success"));
				session.put("listview", conditions);
				RequestDispatcher reqDispatcher  = request.getRequestDispatcher("/booking.jsp");
				System.out.println("login successful!finish dispatch!booking=> ");
				reqDispatcher.forward(request,response);
				System.out.println("dispatched!");
			}else{
				System.out.println("retStr <> success");
				session.put("retStr", retStr);
				ServletActionContext.getResponse().sendRedirect("login.jsp");
			}
			**/
				
		}
		return null;

	}
}
