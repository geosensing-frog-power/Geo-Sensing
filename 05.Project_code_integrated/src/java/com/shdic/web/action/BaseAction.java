package com.shdic.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author : 
 * Description:
 * Company: 
 * 
 * 
 *
 */
public class BaseAction extends ActionSupport implements SessionAware,
ServletRequestAware, ServletContextAware, ServletResponseAware{

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(BaseAction.class);

	protected Map<String, Object> session;
	protected HttpServletRequest request;
	protected ServletContext context;
	protected HttpServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void printXml(String xml) {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//logger.info("****JSON : "+xml);
		out.print(xml);
		out.flush();
		out.close();
		
	}
	
	public void printJSON(JSON json) {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			logger.info("错误信息：" + e.getMessage());
			e.printStackTrace();
		}
		String jsonString="";
		if(json!=null){
			jsonString=json.toString();
			logger.info(jsonString);
			
		}
		
		out.print(jsonString);
		out.flush();
		out.close();
		
	}


	
	
}

