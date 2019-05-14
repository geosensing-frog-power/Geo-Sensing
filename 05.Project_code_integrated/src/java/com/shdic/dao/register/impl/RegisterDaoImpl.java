package com.shdic.dao.register.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shdic.conn.CreateConn;
import com.shdic.dao.dmgl.DmglDao;
import com.shdic.dao.register.RegisterDao;
import com.shdic.tools.checkData;
import com.sun.faces.util.ToolsUtil;

@SuppressWarnings("unchecked")
@Repository("registerDao")

public class RegisterDaoImpl implements RegisterDao {

	@Override
	public String registerUser(Map conditions) throws Exception {
    	String result = "";
    	Connection conn=null;ResultSet rs = null;
    	PreparedStatement ps=null;
    	List reList = new ArrayList();
    	String email = (String) conditions.get("email");
    	String firstname = (String) conditions.get("firstname");
    	String lastname = (String) conditions.get("lastname");
    	String password1 = (String) conditions.get("password1");
    	String cc_name = (String) conditions.get("cc_name");
    	String cc_number = (String) conditions.get("cc_number");
    	String cc_cvv = (String) conditions.get("cc_cvv");
    	String cc_expiration = (String) conditions.get("cc_expiration");

		try{
//			if (validation.emailValidation(email)){
//				return "emailIsExisted";
//			}
//			else{
//			}	
				//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //oracle driver
				//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb");
			conn =  (Connection) new CreateConn().createDBSession();	
			if(checkEmailExist(conn,email)){
					result = "email existed!";
					return result;
				}
				//conn.setAutoCommit(false);
				StringBuffer sql = new StringBuffer("insert into t_user_info (user_id," +
						"firstname," +
						"lastname," +
						"email," +
						"password," +
						"cc_name," +
						"cc_number," +
						"cc_cvv," +
						"cc_expiration) values (karl.Q_user_info.nextval,?,?,?,?,?,?,?,?) ");
				
				System.out.println("SQL="+sql+"*"+email);
				ps = conn.prepareStatement(sql.toString());
				ps.setString(1, firstname);
				ps.setString(2, lastname);
				ps.setString(3, email);
				ps.setString(4, password1);
				ps.setString(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.executeUpdate();
				conn.commit();
				System.out.println("register success!");
				result = "success";

		}catch(Exception e){
			result = "error,please try again";	
			try{
				conn.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
				System.err.println("rollback error");
			}
			e.printStackTrace();
			throw e;			
		}finally{
			if (rs != null)
	        {
	            try
	            {
	                rs.close();
	            } catch (Exception e)
	            {
	            }
	        }
			if (ps != null)
	        {
	            try
	            {
	            	ps.close();
	            } catch (Exception e)
	            {
	            }
	        }
			 if (conn != null)
		        {
		            try
		            {
		                conn.close();
		            } catch (Exception e)
		            {
		            }
		        }
		        conn = null;
		}
		return result;
	}
	
	
	
	public boolean checkEmailExist(Connection conn,String email) throws Exception{
		boolean result = false;
		ResultSet rs = null;
		PreparedStatement ps=null;
		
		try{
			StringBuffer sql = new StringBuffer("select * from T_USER_INFO where EMAIL=?");
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, email);
			rs=ps.executeQuery();
			if (rs.next())
				{
					result = true;
			    }
				
			else
				{
					result = false;
				}
			return result;
		}catch(Exception e){
			result = false;
			try{
				conn.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
				System.err.println("rollback error");
			}
			e.printStackTrace();
			throw e;			
		}
	}	

}
