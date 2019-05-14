package com.shdic.web.action.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.shdic.bean.SlotBean;
import com.shdic.web.action.BaseAction;

@SuppressWarnings("unchecked")
@ParentPackage("struts-default")
@Namespace("/")
@Action(value="testAjaxAction")
public class TestAjaxAction extends BaseAction {
	
	String retStr = null;
	public String callAjax() throws IOException, ServletException{
	    
	    try{
			
			String email = request.getParameter("email")==null?"x":request.getParameter("email");
			String password = request.getParameter("password")==null?"x":request.getParameter("password");
			//conditions.put("email", email);
			//conditions.put("password", password);
			//retStr = loginService.insertName(conditions);
			//retStr = loginService.insertUser(conditions);
			System.out.println("login successful!email=> "+email+password);
			//System.out.println("retStr=> "+retStr);
			
			SlotBean slot1 =new SlotBean("A","01","Available","2","08:00","06:00");
			SlotBean slot2 =new SlotBean("A","02","Available","2","08:00","06:00");
			
			ArrayList<SlotBean> country=new ArrayList<SlotBean>();
			country.add(slot1);
			country.add(slot2);
			//country=FetchData.getAllCountries();
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(country, 
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
				//session.put("listview", conditions);
				RequestDispatcher reqDispatcher  = request.getRequestDispatcher("/booking.jsp");
				System.out.println("login successful!finish dispatch!booking=> ");
				reqDispatcher.forward(request,response);
				System.out.println("dispatched!");
			}else{
				System.out.println("retStr <> success");
				//session.put("retStr", retStr);
				ServletActionContext.getResponse().sendRedirect("login.jsp");
			}**/
				
		}
		return null;
	}
}