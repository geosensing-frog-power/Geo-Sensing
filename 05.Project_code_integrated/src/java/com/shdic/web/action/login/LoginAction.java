package com.shdic.web.action.login;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.shdic.service.login.LoginService;
import com.shdic.web.action.BaseAction;

@SuppressWarnings("unchecked")
@ParentPackage("struts-default")
@Namespace("/")
@Action(value="loginAction")
public class LoginAction extends BaseAction{
	

	@Resource(name="loginService")
	private LoginService loginService;
	
	String name = null;
	Logger logger = LoggerFactory.getLogger(LoginAction.class);

	//add user information 
		public String insertUser(){
		    String retStr = "";
		    try{
				Map conditions = new HashMap();
				String email = request.getParameter("email")==null?"x":request.getParameter("email");
				String password = request.getParameter("password")==null?"x":request.getParameter("password");
				conditions.put("email", email);
				conditions.put("password", password);
				//retStr = loginService.insertName(conditions);
				retStr = loginService.insertUser(conditions);
				System.out.println("login successful!email=> "+email+password);
		    }catch(Exception e){
		    	retStr = "Login failed,Please try it again!";	
				e.printStackTrace();
			}finally{
				pw(new StringBuffer(retStr));
			}
			return null;

		}

		/* 
		//Search for name
		public String getName(){
		    String retStr = "";
		    List  v_result = null;
		    try{
				Map conditions = new HashMap();
			    name = request.getParameter("name")==null?"":request.getParameter("name");	
				
			    //prevent sqli using pattern check 	
				String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{1,16}$";
				if (!name.matches(regex)){
					throw new Exception(name+" is not matched!(a-zA-Z0-9)");
					
				}else{	
					conditions.put("name", name);
					v_result = loginService.getName(conditions);					
				}
				
			    
			    //code permit SQL injection
			    conditions.put("name", name);
				//v_result = loginService.getName(conditions);	
				//输出列表中的list
				System.out.println("list_result_number="+v_result.size());
				for (int c=0;c<v_result.size();c++){
					System.out.println("print="+ v_result.get(c).toString());;
				}
				
				
		    }catch(Exception e){
		    	retStr = "Failed!";	
		    	System.out.println("Logging: "+name+" is matched!(a-zA-Z0-9)");
				e.printStackTrace();
			}finally{
				pw(new StringBuffer(retStr));
			}
			return null;

		}		
		*/	
	private void pw(StringBuffer xmlTx){
		PrintWriter ps = null;
		try{
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ps = ServletActionContext.getResponse().getWriter();
		}catch(Exception e){
			e.printStackTrace();
		}
		//将信息返回至页面
		if(ps != null){
			ps.print(xmlTx.toString());
		}
	}
	
	

}