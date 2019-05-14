package com.shdic.web.action.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.shdic.web.action.BaseAction;
@SuppressWarnings("unchecked")
@ParentPackage("struts-default")
@Namespace("/")
@Action(value="testResponseAction")

public class TestResponseAction extends BaseAction {
	
	public String direct() throws IOException{
		Map conditions = new HashMap();
		String email = request.getParameter("email")==null?"x":request.getParameter("email");
		String name= "testname";
		
		System.out.println("email:"+email);
		conditions.put("email", email);
		conditions.put("name", name);
		System.out.println("if session is null:"+session.equals(null));
		session.put("listview", conditions);
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("request.getContextPath:"+request.getContextPath());
		System.out.println("request.getScheme:"+request.getScheme());
		System.out.println("request.getServerName:"+request.getServerName());
		System.out.println("basePath:"+basePath);
		//response.sendRedirect(getBasePath()+"/common/inputStreamError.jsp");
		//response.sendRedirect("/Hweb/test_direct_ok.jsp");
		RequestDispatcher reqDispatcher  = request.getRequestDispatcher("/test_direct_ok.jsp");	
		try {
			reqDispatcher.forward(request,response);
			System.out.println("dispatched!");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//		request.getRequestDispatcher() 
		//return "test_dispatch";		
		return null;	
		
	}
	
	private void pw(StringBuffer xmlTx){
		PrintWriter ps = null;
		try{
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ps = ServletActionContext.getResponse().getWriter();
			//direct to page 
			ServletActionContext.getResponse().sendRedirect("test_direct.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
		//将信息返回至页面
		if(ps != null){
			ps.print(xmlTx.toString());
		}
	}
}	
