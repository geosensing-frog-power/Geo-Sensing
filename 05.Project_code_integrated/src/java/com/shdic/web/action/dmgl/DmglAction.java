package com.shdic.web.action.dmgl;

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
import com.shdic.service.dmgl.DmglService;
import com.shdic.web.action.BaseAction;

@SuppressWarnings("unchecked")
@ParentPackage("struts-default")
@Namespace("/")
@Action(value="dmglAction")
public class DmglAction extends BaseAction{
	

	@Resource(name="dmglService")
	private DmglService dmglService;
	
	String name = null;


	Logger logger = LoggerFactory.getLogger(DmglAction.class);

	//保存修改用户信息
		public String insertName(){
		    String retStr = "";
		    try{
				Map conditions = new HashMap();
				String name = request.getParameter("name")==null?"":request.getParameter("name");	
				conditions.put("name", name);
				retStr = dmglService.insertName(conditions);
		    }catch(Exception e){
		    	retStr = "操作失败，请重试！";	
				e.printStackTrace();
			}finally{
				pw(new StringBuffer(retStr));
			}
			return null;

		}

		
		//Search for name
		public String getName(){
		    String retStr = "";
		    List  v_result = null;
		    try{
				Map conditions = new HashMap();
			    name = request.getParameter("name")==null?"":request.getParameter("name");	
				
			    /*prevent sqli using pattern check 	
				String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{1,16}$";
				if (!name.matches(regex)){
					throw new Exception(name+" is not matched!(a-zA-Z0-9)");
					
				}else{	
					conditions.put("name", name);
					v_result = dmglService.getName(conditions);					
				}
				**/
			    
			    /*code permit SQL injection*/
			    conditions.put("name", name);
				v_result = dmglService.getName(conditions);	
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
		
		//update name
		public String updatePassword(){
		    String retStr = "";
		    //Integers =1;
		    List  v_result = null;
		    try{
				Map conditions = new HashMap();
				String password = request.getParameter("password")==null?"":request.getParameter("password");	
				conditions.put("password", password);
				
				v_result = dmglService.updatePassword(conditions);
				
				//输出列表 中的list
				System.out.println("list_result_number="+v_result.size());

		    }catch(Exception e){
		    	retStr = "Failed!";	
				e.printStackTrace();
			}finally{
				pw(new StringBuffer(retStr));
			}
			return null;

		}		
		
		//delete name
		public String deleteName(){
		    String retStr = "";
		    List  v_result = null;
		    try{
				Map conditions = new HashMap();
				String name = request.getParameter("name")==null?"":request.getParameter("name");	
				conditions.put("name", name);
				
				v_result = dmglService.deleteName(conditions);
				
				//输出列表 中的list
				System.out.println("list_result_number="+v_result.size());
				
				
		    }catch(Exception e){
		    	retStr = "Failed!";	
				e.printStackTrace();
			}finally{
				pw(new StringBuffer(retStr));
			}
			return null;

		}			
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
