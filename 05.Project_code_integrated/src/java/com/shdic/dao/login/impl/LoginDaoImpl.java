package com.shdic.dao.login.impl;

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

import com.shdic.dao.dmgl.DmglDao;
import com.shdic.dao.login.LoginDao;

@SuppressWarnings("unchecked")
@Repository("loginDao")

public class LoginDaoImpl implements LoginDao {
@Override
	public String insertUser(Map conditions) throws Exception {
		// TODO Auto-generated method stub
    	String result = "";
    	Connection conn=null;ResultSet rs = null;
    	PreparedStatement ps=null;
    	List reList = new ArrayList();
    	String email = (String) conditions.get("email");
    	String password = (String) conditions.get("password");
    	
//		+conditions.get("email") 
//		+conditions.get("password")
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //oracle driver
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.19.110:1521:karldb", "karl", "karldb");  
			//conn.setAutoCommit(false);
			StringBuffer sql = new StringBuffer("select * from T_USER_INFO where EMAIL=? and PASSWORD=?");
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, email);
			ps.setString(2, password);
			rs=ps.executeQuery();
			System.out.println("email:"+email+" password"+password);
			if (rs.next())
				{
					System.out.println("login success!");
					result = "login success!";	
			    }
				
			else
				{
					System.out.println("login failed.");
					result = "The email or password is incorrect!";
				}
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
}
