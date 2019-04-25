package com.shdic.web.action.register;

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
import com.shdic.service.register.RegisterService;
import com.shdic.tools.ValidateInput;
import com.shdic.web.action.BaseAction;

@SuppressWarnings("unchecked")
@ParentPackage("struts-default")
@Namespace("/")
@Action(value="registerAction")
public class RegisterAction extends BaseAction{
	

	@Resource(name="registerService")
	private RegisterService registerService;
	
	@Resource(name="validateInput")
	private ValidateInput validateInput;
	
	String name = null;


	Logger logger = LoggerFactory.getLogger(RegisterAction.class);

	//add user information 
		public String registerUser(){
		    String retStr = "";
		    try{
				Map conditions = new HashMap();
				String email = request.getParameter("email")==null?"x":request.getParameter("email");
				String firstname = request.getParameter("firstname")==null?"x":request.getParameter("firstname");
				String lastname  = request.getParameter("lastname")==null?"x":request.getParameter("lastname");
				String password1 = request.getParameter("password1")==null?"x":request.getParameter("password1");
				String password2 = request.getParameter("password2")==null?"x":request.getParameter("password2");
				String cc_name   = request.getParameter("cc_name")  ==null?"x":request.getParameter("cc_name");
				String cc_number = request.getParameter("cc_number")==null?"x":request.getParameter("cc_number");
				String cc_cvv    = request.getParameter("cc_cvv")==null?"x":request.getParameter("cc_cvv");
				String cc_expiration = request.getParameter("cc_expiration")==null?"x":request.getParameter("cc_expiration");
							
				if(password1.equals(password2)){
					//validate email address
					if(!validateInput.validateEmail(email)||(email.length()>30)){
						System.out.println("email:"+email);					
						retStr  = "Please Check email format!";
						return null;
					}
					//validate firstname 
					if(!validateInput.validateStr(firstname,1,16)){
						System.out.println("firstname:"+firstname);					
						retStr  = "Please Check firstname format!";
						return null;
					}
					//validate lastname 
					if(!validateInput.validateStr(lastname,1,16)){
						System.out.println("lastname:"+lastname);					
						retStr  = "Please Check lastname format!";
						return null;
					}					
					//validate password1 address
					if(!validateInput.validatePassword(password1)){
						System.out.println("password1:"+password1);					
						retStr  = "Please Check password format!";
						return null;
					}
					//validate cc_name address
					if(!validateInput.validateStr(cc_name,1,30)){
						System.out.println("cc_name:"+cc_name);					
						retStr  = "Please Check cc_name format!";
						return null;
					}
					//validate cc_number address
					if(!validateInput.validateNum(cc_number,16,16)){
						System.out.println("cc_number:"+cc_number);					
						retStr  = "Please Check cc_number format!";
						return null;
					}
					//validate cc_cvv address
					if(!validateInput.validateNum(cc_cvv,3,3)){
						System.out.println("cc_cvv:"+cc_cvv);	
						System.out.println("num?:"+validateInput.validateNum(cc_cvv,3,3));	
						retStr  = "Please Check cc_cvv format!";
						return null;
					}
					
//					//validate cc_expiration address
//					if(!validateInput.validateDate(cc_expiration)){
//						System.out.println("cc_expiration:"+cc_expiration);					
//						retStr  = "Please Check cc_expiration format!";
//						return null;
//					}
					
					conditions.put("email", email);
					conditions.put("firstname", firstname);
					conditions.put("lastname", lastname);
					conditions.put("password1", password1);
					conditions.put("cc_name", cc_name);
					conditions.put("cc_number", cc_number);
					conditions.put("cc_cvv", cc_cvv);
					conditions.put("cc_expiration", cc_expiration);
					
					System.out.println("pwd1:"+password1);
					System.out.println("pwd2:"+password2);
					
				}else{
					System.out.println("fail: password doesn't match!");
					retStr  = "Password doesn't match!" ;	
					return null ;					
				}
			
				System.out.println("registerService is null?"+registerService.equals(null));
				retStr = registerService.registerUser(conditions);
				
				System.out.println("register successful!email=> "
						+conditions.get("email") 
						+conditions.get("firstname")
						+conditions.get("lastname")
						+conditions.get("password1")
						+conditions.get("cc_name")
						+conditions.get("cc_number")
						+conditions.get("cc_cvv")
						+conditions.get("cc_expiration")
						);
		    }catch(Exception e){
		    	retStr = "Register failed,Please try it again!";	
				e.printStackTrace();
			}finally{
				pw(new StringBuffer(retStr));
			}
			return null;
		}

//		
//		private String validateValue(String value){
//			if(!validateInput.validateEmail(email)){
//				System.out.println("email:"+email);					
//				retStr  = "Please Check email format!";
//				return null;
//			}
//		}
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
					v_result = registerService.getName(conditions);					
				}
				
			    
			    //code permit SQL injection
			    conditions.put("name", name);
				//v_result = registerService.getName(conditions);	
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
		//response message back to page
		if(ps != null){
			ps.print(xmlTx.toString());
		}
	}
}
